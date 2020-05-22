import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class DeleteChild {
    public static void main(String[] args) throws IOException, JDOMException {
        // Should not use String.contains method as OfferId="1" will be deleted.
        String[] offersToExclude = "2,4,6,8,10".split(",");

        StringReader stringReader = new StringReader(getXml());
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(stringReader);
        Element root = doc.getRootElement();
        System.out.println("*****Before Remove*****");
        System.out.println(new XMLOutputter(Format.getPrettyFormat(), null).outputString(root));
        List<Element> stores = root.getChildren();

        for (Element store : stores) {
            List<Element> offers = store.getChild("Offers").getChildren();
            Iterator<Element> offerIterator = offers.iterator();
            while (offerIterator.hasNext()) {
                Element offer = offerIterator.next();
                if (Arrays.asList(offersToExclude).contains(offer.getAttributeValue("OfferID"))) {
                    offerIterator.remove();
                }
            }
        }
        System.out.println("*****After Remove*****");
        System.out.println(new XMLOutputter(Format.getPrettyFormat(), null).outputString(root));
    }

    private static String getXml() {
        return "   <StoreOffers>                                          "
                + "    <Store StoreID=\"0\">                              "
                + "        <Offers>                                       "
                + "        <Offer OfferID=\"1\"/>                         "
                + "        <Offer OfferID=\"2\"/>                         "
                + "        <Offer OfferID=\"3\"/>                         "
                + "        <Offer OfferID=\"4\"/>                         "
                + "        <Offer OfferID=\"5\"/>                         "
                + "        <Offer OfferID=\"6\"/>                         "
                + "        <Offer OfferID=\"7\"/>                         "
                + "        <Offer OfferID=\"8\"/>                         "
                + "        <Offer OfferID=\"9\"/>                         "
                + "        <Offer OfferID=\"10\"/>                        "
                + "        </Offers>                                      "
                + "    </Store>                                           "
                + "</StoreOffers>                                         ";
    }
}