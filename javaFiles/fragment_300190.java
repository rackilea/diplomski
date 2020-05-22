import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Stack {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new ByteArrayInputStream(XML.getBytes()));

        Map<String, String> map = readFromDocument(doc);

        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    private static Map<String, String> readFromDocument(Document doc) {
        Map<String, String> map = new HashMap<>();

        NodeList applicationNodes = doc.getElementsByTagName("Application");

        for(int k = 0; k < applicationNodes.getLength(); k++) {
            Node applicationNode = applicationNodes.item(k);

            NodeList subNodes = applicationNode.getChildNodes();

            String key = null;
            String value = null;

            for(int j = 0; j < subNodes.getLength(); j++) {
                Node node = subNodes.item(j);

                if("Name".equals(node.getNodeName())) {
                    key = node.getTextContent();
                } else if("StatusIO-Email".equals(node.getNodeName())) {
                    value = node.getTextContent();
                }
            }

            if(key == null || value == null) {
                throw new IllegalStateException("Could not find all attributes of node, key=" + key + ", value=" + value);
            }

            map.put(key, value);
        }
        return map;
    }

    private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Domains>" +
            "    <Domain name=\"Parts\">" +
            "        <Applications>" +
            "            <Application>" +
            "                <Name>Paragon</Name>" +
            "                <StatusIO-Email> component+d6bb9f42-814c-40de-bb3d-c67c8972c8d2@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>PartsAssistanceCenter</Name>" +
            "                <StatusIO-Email>component+066ac96e-c038-477a-b477-9b17d8183a61@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>PartsPricingFeedback</Name>" +
            "                <StatusIO-Email>component+d34dd6d3-b75c-4777-9ed2-99db85dc591d@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "        </Applications>" +
            "    </Domain>" +
            "    <Domain name=\"Admin\">" +
            "        <Applications>" +
            "            <Application>" +
            "                <Name>DealerAgreementSystem</Name>" +
            "                <StatusIO-Email>component+bc3e0990-fa84-4e5f-8ca5-25cec10e82a1@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>DealerFinancialSystem</Name>" +
            "                <StatusIO-Email> component+50c88a69-b630-465e-9538-d42184489987@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>DealerPersonnelMaintencance</Name>" +
            "                <StatusIO-Email>component+74ac5cdb-77d8-4b45-8ead-fe2aa981d8fb@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>DealerWebSiteContentManagement</Name>" +
            "                <StatusIO-Email>component+7b794d21-b74c-4a07-afcf-baab0a9d7384@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "        </Applications>" +
            "    </Domain>" +
            "    <Domain name=\"Sales\">" +
            "        <Applications>" +
            "            <Application>" +
            "                <Name>C3RemarketingProgram</Name>" +
            "                <StatusIO-Email>component+5a19286d-94de-483c-83f2-8f26bcb9eb2e@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>CARFAX</Name>" +
            "                <StatusIO-Email>component+672dc29d-9990-499c-a9b2-1284032dab62@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>CertificateProgram</Name>" +
            "                <StatusIO-Email>component+9a331d90-7576-4b3c-b7bc-f04fe7f43a81@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>CompetitorInformation</Name>" +
            "                <StatusIO-Email>component+ede2b266-b8fb-426f-a2dd-cfa03f91ae22@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>CustomizedDelivery</Name>" +
            "                <StatusIO-Email>component+b5a9668f-8097-4904-8973-f1fa3c914f52@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>DE1</Name>" +
            "                <StatusIO-Email> component+6262e08b-0781-47a6-ac68-1ef36500610b@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>DistributionAndLogistics</Name>" +
            "                <StatusIO-Email>component+89e75ea9-bc54-4c7a-978a-b638241c407a@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>DistributionandLogistics-Sprinter</Name>" +
            "                <StatusIO-Email>component+668f00bc-dea4-4a56-8d99-c4bfc7de6410@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>EuropeanDeliveryProgram</Name>" +
            "                <StatusIO-Email>component+69c8aa70-4fed-4946-97fd-6f08e0128f87@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>ExtendedLimitedWarranty</Name>" +
            "                <StatusIO-Email>component+5ea8d40a-2c5b-438f-9c23-198e1c78c247@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>ExtendedLimitedWarrantyVans</Name>" +
            "                <StatusIO-Email>component+c14c627d-ec5c-4974-ab88-b4f201f48c48@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>F&amp;IPro</Name>" +
            "                <StatusIO-Email> component+bdf17e22-f4e9-4e21-a5b6-a8c25eb72aa0@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>FleetInfo-DealerSite</Name>" +
            "                <StatusIO-Email>component+e2c43815-fcc4-4538-bde3-3f41d763d57a@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>FleetSales-CustomerSite</Name>" +
            "                <StatusIO-Email>component+3805c27a-d2b2-4de5-86e6-d6c35d12ee16@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>GeographicLinesets</Name>" +
            "                <StatusIO-Email> component+94ee1578-1ff1-498f-900a-d6750b55a74f@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>KnownExporterSearch</Name>" +
            "                <StatusIO-Email>component+fb403be8-14b1-4485-851e-c3b0c93a905a@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>ManheimAuctions</Name>" +
            "                <StatusIO-Email>component+0d9e6bdb-ea6a-48a5-ae9f-c496dad09782@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>MarketSupportSystem</Name>" +
            "                <StatusIO-Email>component+864d733f-c9b5-4a66-a67f-94b10a964022@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>MBAdvantage</Name>" +
            "                <StatusIO-Email>component+6301fa14-81a6-4823-aa99-66c0d1244169@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>MBBusDevCenter</Name>" +
            "                <StatusIO-Email>component+7a46434f-143d-4ddc-ad36-099cea6cfac5@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>mbrace-ElectronicSubscriberAgreement</Name>" +
            "                <StatusIO-Email>component+47c62d30-406f-44e8-a55c-6780cc2ec016@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>MercedesProgramInfo</Name>" +
            "                <StatusIO-Email>component+d5cab941-5e62-4134-8e8e-c31f2d3fe5be@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>PrepaidMaintenance</Name>" +
            "                <StatusIO-Email>component+feb2791b-6c76-4047-a068-d989b32c14e2@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>PrepaidMaintenanceVans</Name>" +
            "                <StatusIO-Email>component+115bee7c-6863-4311-806f-ddb485f4e2a5@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>RDAResourceManager</Name>" +
            "                <StatusIO-Email>component+a7024b6c-be83-4814-84ad-e23b9ca7dc30@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>VehicleConfigurator</Name>" +
            "                <StatusIO-Email>component+5beda28e-dfd2-422e-83cb-ca98226db630@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>VehicleWraps</Name>" +
            "                <StatusIO-Email>component+b02e0618-c013-434c-9142-aacc907a7231@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "        </Applications>" +
            "    </Domain>" +
            "    <Domain name=\"Service\">" +
            "        <Applications>" +
            "            <Application>" +
            "                <Name>ASRALocal</Name>" +
            "                <StatusIO-Email>component+704833c3-c7ef-488c-a84e-6818652a9993@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>MarketResearchAfterSales</Name>" +
            "                <StatusIO-Email> component+1008863b-df94-4422-b7d0-24e754c8f92e@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>MOC1TabletSolutions</Name>" +
            "                <StatusIO-Email>component+10a3086f-da72-45ea-8cec-ec12d1aa7fae@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>OperationsGuidelines</Name>" +
            "                <StatusIO-Email>component+952684d7-8561-4ab8-9268-776dcae72c85@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>smartTekInfo</Name>" +
            "                <StatusIO-Email>component+b52b1e02-51a3-48b7-a16b-ba2000cf1c8c@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>smartWarrantyManual</Name>" +
            "                <StatusIO-Email>component+a23c655a-1f0c-4af3-880c-636fb39fe334@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>SeatProtection</Name>" +
            "                <StatusIO-Email>component+29b6c2a0-3a72-4934-8f1e-ecd674503552@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>ServiceandPartsSalesTools</Name>" +
            "                <StatusIO-Email>component+a5226dfc-beeb-4b75-8609-09518ad5140d@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>SmallRepair</Name>" +
            "                <StatusIO-Email>component+892f5cb6-e8aa-4608-9d1f-d97197e37304@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>STARTekInfo</Name>" +
            "                <StatusIO-Email>component+cac881e6-ef80-4b80-a135-ba559ed1abfe@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "            <Application>" +
            "                <Name>WarrantyManual</Name>" +
            "                <StatusIO-Email>component+1f2c68d9-45d5-4eba-9533-1fe31441c44b@notifications.statuspage.io</StatusIO-Email>" +
            "            </Application>" +
            "        </Applications>" +
            "    </Domain>" +
            "</Domains>"; 
}