import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class YahooCurrencyConverter implements CurrencyConverter
{
    public float getConversionRate(String from, String to) throws IOException
    {
        HttpClientBuilder builder = HttpClientBuilder.create();
        try (CloseableHttpClient httpclient = builder.build())
        {
            HttpGet httpGet = new HttpGet("http://quote.yahoo.com/d/quotes.csv?s=" + from + to + "=X&f=l1&e=.csv");
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpGet, responseHandler);

            return Float.parseFloat(responseBody);
        }
    }

    public static void main(String[] arguments) throws IOException
    {
        YahooCurrencyConverter yahooCurrencyConverter = new YahooCurrencyConverter();
        float current = yahooCurrencyConverter.getConversionRate("USD", "ILS");
        System.out.println(current);
    }
}