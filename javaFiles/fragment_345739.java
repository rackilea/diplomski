import org.json.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main
{
    final String productID = "8513070";
    final String productURL = "http://www.asos.com/prd/";
    final Product product = new Product();

    public static void main( String[] args )
    {
        new Main();
    }

    private Main()
    {
        getProductDetails( productURL, productID );
        System.out.println( "ID: " + product.productID + ", Name: " + product.productName + ", Price: " + product.productPrice );
    }

    private void getProductDetails( String url, String productID )
    {
        try
        {
            // Append the product url and the product id to retrieve the product HTML
            final String appendedURL = url + productID;

            // Using Jsoup we'll connect to the url and get the HTML
            Document document = Jsoup.connect( appendedURL ).get();
            // We parse the HTML only looking for the product section
            Element elementById = document.getElementById( "asos-product" );
            // To simply get the title we look for the H1 tag
            Elements h1 = elementById.getElementsByTag( "h1" );

            // Because more than one H1 tag is returned we only want the tag that isn't empty
            if ( !h1.text().isEmpty() )
            {
                // Add all data to Product object
                product.productID = productID;
                product.productName = h1.text().trim();
                product.productPrice = getProductPrice(productID);
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

    private String getProductPrice( String productID )
    {
        try
        {
            // Append the api url and the product id to retrieve the product price JSON document
            final String apiURL = "http://www.asos.com/api/product/catalogue/v2/stockprice?productIds=" + productID + "&store=COM";
            // Using Jsoup again we connect to the URL ignoring the content type and retrieve the body
            String jsonDoc = Jsoup.connect( apiURL ).ignoreContentType( true ).execute().body();

            // As its JSON we want to parse the JSONArray until we get to the current price and return it.
            JSONArray jsonArray = new JSONArray( jsonDoc );
            JSONObject currentProductPriceObj = jsonArray
                    .getJSONObject( 0 )
                    .getJSONObject( "productPrice" )
                    .getJSONObject( "current" );
            return currentProductPriceObj.getString( "text" );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }

        return "";
    }

    // Simple Product object to store the data
    class Product
    {
        String productID;
        String productName;
        String productPrice;
    }
}