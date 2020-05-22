import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class CountriesService
{
    private static final String EL_COUNTRY = "ISO_3166-1_Entry";
    private static final String EL_COUNTRY_NAME = "ISO_3166-1_Country_name";
    private static final String EL_COUNTRY_CODE = "ISO_3166-1_Alpha-2_Code_element";
    private List<Country> countries = new ArrayList<Country>();

    public CountriesService(InputStream countriesList)
    {
        parseCountriesList(countriesList);
    }

    public List<Country> getCountries()
    {
        return countries;
    }

    private void parseCountriesList(InputStream countriesList)
    {
        countries.clear();
        try
        {
            Document document = parse(countriesList);
            Element root = document.getRootElement();
            //noinspection unchecked
            Iterator<Element> i = root.elementIterator(EL_COUNTRY);
            while (i.hasNext())
            {
                Element countryElement = i.next();
                Element countryName = countryElement.element(EL_COUNTRY_NAME);
                Element countryCode = countryElement.element(EL_COUNTRY_CODE);

                String countryname = countryName.getText();
                countries.add(new Country(countryname, countryCode.getText()));
            }
        }
        catch (DocumentException e)
        {
            log.error(e, "Cannot read countries list");
        }
        catch (IOException e)
        {
            log.error(e, "Cannot read countries list");
        }
    }

    public static Document parse(InputStream inputStream) throws DocumentException
    {
        SAXReader reader = new SAXReader();
        return reader.read(inputStream);
    }
}