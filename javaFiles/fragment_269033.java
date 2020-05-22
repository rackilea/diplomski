import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomTest
{
    public static void main(String[] args)
    {
        File iFile = new File("src/main/resources/domtest.xml");

        try
        {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(iFile));

            new DomTest().parse2(doc);
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Failed to parse " + iFile.getAbsolutePath());
            System.exit(1);
        }

        System.exit(0);
    }

    public void parse1(Document doc)
    {
        NodeList nList8 = doc.getElementsByTagName("Transaction");

        for (int temp8 = 0; temp8 < nList8.getLength(); temp8++) 
        {
            Node nNode8 = nList8.item(temp8);

            if (nNode8.getNodeType() == Node.ELEMENT_NODE) 
            {
                Element eElement8 = (Element) nNode8;   

                System.out.println("TransactionType : " + eElement8.getElementsByTagName("TransactionType").item(0).getTextContent());
                System.out.println("TransactionFor : " + eElement8.getElementsByTagName("TransactionFor").item(0).getTextContent());
                System.out.println("TransactionDate : " + eElement8.getElementsByTagName("TransactionDate").item(0).getTextContent());
                System.out.println("ItemReference : " + eElement8.getElementsByTagName("ItemReference").item(0).getTextContent());
                System.out.println("Amount : " + eElement8.getElementsByTagName("Amount").item(0).getTextContent());
                System.out.println("AmountPaid : " + eElement8.getElementsByTagName("AmountPaid").item(0).getTextContent());
                System.out.println("Balance : " + eElement8.getElementsByTagName("Balance").item(0).getTextContent());
                System.out.println("Status : " + eElement8.getElementsByTagName("Status").item(0).getTextContent());

                if (eElement8.getElementsByTagName("SupplierID").item(0).getTextContent() == null)
                {
                    System.out.println("ConsumerID : " + eElement8.getElementsByTagName("ConsumerID").item(0).getTextContent());                                    
                } else if (eElement8.getElementsByTagName("ConsumerID").item(0).getTextContent() == null) {
                    System.out.println("SupplierID : " + eElement8.getElementsByTagName("SupplierID").item(0).getTextContent());
                }
            }
        }

        return;
    }

    public void parse2(Document doc)
    {
        Element transactionsEl = doc.getDocumentElement();

        NodeList transactionEls = transactionsEl.getElementsByTagName("Transaction");

        for (int txIdx = 0; txIdx < transactionEls.getLength(); txIdx++) 
        {
            // we know that this an Element node because we used getElementsByTagName above
            Element transactionEl = (Element) transactionEls.item(txIdx);

            String transactionType = null;
            String transactionFor = null;
            String transactionDate = null;
            String itemReference = null;
            String amount = null;
            String amountPaid = null;
            String balance = null;
            String status = null;
            String consumerID = null;
            String supplierID = null;

            NodeList transactionElChildNodes = transactionEl.getChildNodes();

            for (int i = 0; i < transactionElChildNodes.getLength(); i++)
            {
                Node n = transactionElChildNodes.item(i);

                if (n.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element someEl = (Element) n;

                    String elName = someEl.getTagName();
                    String text = someEl.getTextContent();

                    if (elName.equals("TransactionType"))
                    {
                        transactionType = text;
                    } else if (elName.equals("TransactionFor")) {
                        transactionFor = text;
                    } else if (elName.equals("TransactionDate")) {
                        transactionDate = text;
                    } else if (elName.equals("ItemReference")) {
                        itemReference = text;
                    } else if (elName.equals("Amount")) {
                        amount = text;
                    } else if (elName.equals("AmountPaid")) {
                        amountPaid = text;
                    } else if (elName.equals("Balance")) {
                        balance = text;
                    } else if (elName.equals("Status")) {
                        status = text;
                    } else if (elName.equals("SupplierID")) {
                        supplierID = text;
                    } else if (elName.equals("ConsumerID")) {
                        consumerID = text;
                    }
                }
            }

            // business logic follows:

            System.out.println("Transaction " + String.valueOf(txIdx));

            if (supplierID != null)
            {
                System.out.println("SupplierID: " + supplierID);
            }

            if (consumerID != null)
            {
                System.out.println("ConsumerID: " + consumerID);
            }
        }

        return;
    }
}