package pmidtomeshConverter;

import java.io.BufferedReader;      
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Convert2MeSH {

    public static void main(String[] args) {


        //BufferedWriter writer = new BufferedWriter(new FileWriter("/home/anjani/eclipse-workspace/pmidtomeshConverter/src/main/resources/outputFiles/pmidMESH.txt", true));

        //Universal Multimap to store the values
        Map<String, String> universalMeSHMap = new HashMap<String, String>();

        FileOutputStream fs;
        BufferedWriter writer;
        try {

            fs = new FileOutputStream("/home/anjani/eclipse-workspace/pmidtomeshConverter/src/main/resources/outputFiles/pmidMESH.txt");
            OutputStreamWriter ow = new OutputStreamWriter(fs);
            writer = new BufferedWriter(ow);

            JSONObject jsonPMIDlist = readJsonFromUrl("https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pubmed&retmode=json&retmax=1000&term=Physiotherapy%5d+OR+Rehabilitation");
            JSONArray pmids = new JSONArray();
            pmids = jsonPMIDlist.getJSONObject("esearchresult").getJSONArray("idlist");

            for(int i=0; i<pmids.length();i++){

                 String baseURL = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&retmode=xml&rettype=abstract&id=";
                 String indPMID = pmids.get(i).toString();

                 Document doc = parseXML(new URL(baseURL + indPMID));

                 // Converts xml from doc into a string
                 String xmlString = xml2String(doc);

                // Converts the xml-string into JSON
                JSONObject jsonWithMeSH = XML.toJSONObject(xmlString);

                JSONObject ind_MeSH = jsonWithMeSH.getJSONObject("PubmedArticleSet").getJSONObject("PubmedArticle").getJSONObject("MedlineCitation");

                List<String> list_MeSH = new ArrayList<String>();
                if (ind_MeSH.has("MeshHeadingList")) {

                for (int j = 0; j < ind_MeSH.getJSONObject("MeshHeadingList").getJSONArray("MeshHeading").length(); j++) {

                    list_MeSH.add(ind_MeSH.getJSONObject("MeshHeadingList").getJSONArray("MeshHeading").getJSONObject(j).getJSONObject("DescriptorName").get("content").toString());
                }

                } else {

                list_MeSH.add("null");

                }

            System.out.println(indPMID + ":" + String.join("\t", list_MeSH));

            // instead of writing to a file, the content is stored in a HashMap
            universalMeSHMap.put(indPMID, String.join("\t", list_MeSH));                

        }

        // Writing the HashMap to the file (This is the answer)
        for (Map.Entry<String,String> entry : universalMeSHMap.entrySet()) {

            writer.append(entry.getKey() + ":" +  entry.getValue() + "\n");

        }

        writer.flush();
        writer.close();

    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ParserConfigurationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SAXException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (TransformerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

private static String xml2String(Document doc) throws TransformerException {

    TransformerFactory transfac = TransformerFactory.newInstance();
    Transformer trans = transfac.newTransformer();
    trans.setOutputProperty(OutputKeys.METHOD, "xml");
    trans.setOutputProperty(OutputKeys.INDENT, "yes");
    trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(2));

    StringWriter sw = new StringWriter();
    StreamResult result = new StreamResult(sw);
    DOMSource source = new DOMSource(doc.getDocumentElement());

    trans.transform(source, result);
    String xmlString = sw.toString();
    return xmlString;

}

private static Document parseXML(URL url) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse((url).openStream());
    doc.getDocumentElement().normalize();
    return doc;
}

private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
        sb.append((char) cp);
    }
    return sb.toString();
}

public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        JSONObject json = new JSONObject(jsonText);
        return json;
    } finally {
        is.close();
    }
}}