package helloxml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.util.Scanner;

public class HelloXML {

    public static void main(String[] args) {

        try {
            HelloXML.writeToXML();
        } catch (ParserConfigurationException | IOException ex) {
            Logger.getLogger(HelloXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void writeToXML() throws ParserConfigurationException, FileNotFoundException, IOException {

        Scanner in = new Scanner(System.in);
        System.out.println("What do you want to name the file as?");
        String fileName = in.nextLine();
        String stigListTitle = stigListTitle();
        String listCreationDate = listCreationDate();

        //DocumentBuilderFactory
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        //DocumentBuilder
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        //Document
        Document xmlDoc = docBuilder.newDocument();

        //XML header
        Element rootElement = xmlDoc.createElement("Benchmark");
        rootElement.setAttribute("xmlns:dsig", "http://www.w3.org/2000/09/xmldsig#");
        rootElement.setAttribute("xmlns:xhtml", "http://www.w3.org/1999/xhtml");
        rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        rootElement.setAttribute("xmlns:cpe", "http://cpe.mitre.org/language/2.0");
        rootElement.setAttribute("xmlns:dc", "http://purl.org/dc/elements/1.1/");
        rootElement.setAttribute("id", "--");
        rootElement.setAttribute("xml:lang", "en");
        rootElement.setAttribute("xsi:schemaLocation", "http://checklists.nist.gov/xccdf/1.1 http://nvd.nist.gov/schema/xccdf-1.1.4.xsd http://cpe.mitre.org/dictionary/2.0 http://cpe.mitre.org/files/cpe-dictionary_2.1.xsd");
        rootElement.setAttribute("xmlns", "http://checklists.nist.gov/xccdf/1.1");

        Element mainStatusDate = xmlDoc.createElement("status");
        mainStatusDate.setAttribute("date", "2015-11-16");
        Text statusDate = xmlDoc.createTextNode("accepted");

        //title
        Element mainTitleTop = xmlDoc.createElement("title");
        Text titleTopText = xmlDoc.createTextNode(stigListTitle);

        //description
        Element mainDescriptionTop = xmlDoc.createElement("description");
        Text descriptionTopText = xmlDoc.createTextNode("A created list of STIG items");

        //notice
        Element mainNoticeTop = xmlDoc.createElement("notice");
        mainNoticeTop.setAttribute("id", "terms-of-use");
        mainNoticeTop.setAttribute("xml:lang", "en");
        Text noticeTopText = xmlDoc.createTextNode("Developed by -- for --");

        //reference
        Element mainReferenceTop = xmlDoc.createElement("reference");
        Element childReferenceTopPublisher = xmlDoc.createElement("dc:publisher");
        Text referenceTopPublisherText = xmlDoc.createTextNode("--");
        Element childReferenceTopSource = xmlDoc.createElement("dc:source");
        Text referenceTopSourceText = xmlDoc.createTextNode("The source? What source?! Theres a source for this stuff?!?!");

        //plaint-text
        Element mainPlainTextTop = xmlDoc.createElement("plain-text");
        mainPlainTextTop.setAttribute("id", "release-info");
        Text plainTextTopText = xmlDoc.createTextNode(listCreationDate);

        //version
        Element mainVersionTop = xmlDoc.createElement("version");
        Text versionTopText = xmlDoc.createTextNode("1");

        //profile MAC1 Classified
        Element mainProfileMac1Classified = xmlDoc.createElement("Profile");
        mainProfileMac1Classified.setAttribute("id", "MAC-1_Classified");
        Element childTitleProfileMac1Classified = xmlDoc.createElement("title");
        Text titleProfileMac1ClassifiedText = xmlDoc.createTextNode("I - Mission Critical Classified");
        Element childDescriptionProfileMac1Classified = xmlDoc.createElement("description");
        Text descriptionProfileMac1Classified = xmlDoc.createTextNode("&lt;ProfileroupDescription&gt;&lt;/ProfileDescription&gt;");
        Element childSelectProfileMac1Classified1 = xmlDoc.createElement("select");
        childSelectProfileMac1Classified1.setAttribute("idref", "V-001");
        childSelectProfileMac1Classified1.setAttribute("selected", "true");
        Element childSelectProfileMac1Classified2 = xmlDoc.createElement("select");
        childSelectProfileMac1Classified2.setAttribute("idref", "V-002");
        childSelectProfileMac1Classified2.setAttribute("selected", "true");

        //profile MAC1 Public
        Element mainProfileMac1Public = xmlDoc.createElement("Profile");
        mainProfileMac1Public.setAttribute("id", "MAC-1_Public");
        Element childTitleProfileMac1Public = xmlDoc.createElement("title");
        Text titleProfileMac1PublicText = xmlDoc.createTextNode("I - Mission Critical Public");
        Element childDescriptionProfileMac1Public = xmlDoc.createElement("description");
        Text descriptionProfileMac1public = xmlDoc.createTextNode("&lt;ProfileroupDescription&gt;&lt;/ProfileDescription&gt;");
        Element childSelectProfileMac1Public1 = xmlDoc.createElement("select");
        childSelectProfileMac1Public1.setAttribute("idref", "V-001");
        childSelectProfileMac1Public1.setAttribute("selected", "true");
        Element childSelectProfileMac1Public2 = xmlDoc.createElement("select");
        childSelectProfileMac1Public2.setAttribute("idref", "V-002");
        childSelectProfileMac1Public2.setAttribute("selected", "true");

        //profile MAC1 Sensitive
        Element mainProfileMac1Sensitive = xmlDoc.createElement("Profile");
        mainProfileMac1Sensitive.setAttribute("id", "MAC-1_Sensitive");
        Element childTitleProfileMac1Sensitive = xmlDoc.createElement("title");
        Text titleProfileMac1SensitiveText = xmlDoc.createTextNode("I - Mission Critical Sensitive");
        Element childDescriptionProfileMac1Sensitive = xmlDoc.createElement("description");
        Text descriptionProfileMac1Sensitive = xmlDoc.createTextNode("&lt;ProfileroupDescription&gt;&lt;/ProfileDescription&gt;");
        Element childSelectProfileMac1Sensitive1 = xmlDoc.createElement("select");
        childSelectProfileMac1Sensitive1.setAttribute("idref", "V-001");
        childSelectProfileMac1Sensitive1.setAttribute("selected", "true");
        Element childSelectProfileMac1Sensitive2 = xmlDoc.createElement("select");
        childSelectProfileMac1Sensitive2.setAttribute("idref", "V-002");
        childSelectProfileMac1Sensitive2.setAttribute("selected", "true");

        //profile MAC2 Classified
        Element mainProfileMac2Classified = xmlDoc.createElement("Profile");
        mainProfileMac2Classified.setAttribute("id", "MAC-2_Classified");
        Element childTitleProfileMac2Classified = xmlDoc.createElement("title");
        Text titleProfileMac2ClassifiedText = xmlDoc.createTextNode("II - Mission Support Classified");
        Element childDescriptionProfileMac2Classified = xmlDoc.createElement("description");
        Text descriptionProfileMac2Classified = xmlDoc.createTextNode("&lt;ProfileroupDescription&gt;&lt;/ProfileDescription&gt;");
        Element childSelectProfileMac2Classified1 = xmlDoc.createElement("select");
        childSelectProfileMac2Classified1.setAttribute("idref", "V-001");
        childSelectProfileMac2Classified1.setAttribute("selected", "true");
        Element childSelectProfileMac2Classified2 = xmlDoc.createElement("select");
        childSelectProfileMac2Classified2.setAttribute("idref", "V-002");
        childSelectProfileMac2Classified2.setAttribute("selected", "true");

        //profile MAC2 Public
        Element mainProfileMac2Public = xmlDoc.createElement("Profile");
        mainProfileMac2Public.setAttribute("id", "MAC-2_Public");
        Element childTitleProfileMac2Public = xmlDoc.createElement("title");
        Text titleProfileMac2PublicText = xmlDoc.createTextNode("II - Mission Support Public");
        Element childDescriptionProfileMac2Public = xmlDoc.createElement("description");
        Text descriptionProfileMac2Public = xmlDoc.createTextNode("&lt;ProfileroupDescription&gt;&lt;/ProfileDescription&gt;");
        Element childSelectProfileMac2Public1 = xmlDoc.createElement("select");
        childSelectProfileMac2Public1.setAttribute("idref", "V-001");
        childSelectProfileMac2Public1.setAttribute("selected", "true");
        Element childSelectProfileMac2Public2 = xmlDoc.createElement("select");
        childSelectProfileMac2Public2.setAttribute("idref", "V-002");
        childSelectProfileMac2Public2.setAttribute("selected", "true");

        //profile MAC2 Sensitive
        Element mainProfileMac2Sensitive = xmlDoc.createElement("Profile");
        mainProfileMac2Sensitive.setAttribute("id", "MAC-2_Sensitive");
        Element childTitleProfileMac2Sensitive = xmlDoc.createElement("title");
        Text titleProfileMac2SensitiveText = xmlDoc.createTextNode("II - Mission Support Sensitive");
        Element childDescriptionProfileMac2Sensitive = xmlDoc.createElement("description");
        Text descriptionProfileMac2Sensitive = xmlDoc.createTextNode("&lt;ProfileroupDescription&gt;&lt;/ProfileDescription&gt;");
        Element childSelectProfileMac2Sensitive1 = xmlDoc.createElement("select");
        childSelectProfileMac2Sensitive1.setAttribute("idref", "V-001");
        childSelectProfileMac2Sensitive1.setAttribute("selected", "true");
        Element childSelectProfileMac2Sensitive2 = xmlDoc.createElement("select");
        childSelectProfileMac2Sensitive2.setAttribute("idref", "V-002");
        childSelectProfileMac2Sensitive2.setAttribute("selected", "true");

        //profile MAC3 Classified
        Element mainProfileMac3Classified = xmlDoc.createElement("Profile");
        mainProfileMac3Classified.setAttribute("id", "MAC-3_Classified");
        Element childTitleProfileMac3Classified = xmlDoc.createElement("title");
        Text titleProfileMac3ClassifiedText = xmlDoc.createTextNode("III - Administrative Classified");
        Element childDescriptionProfileMac3Classified = xmlDoc.createElement("description");
        Text descriptionProfileMac3Classified = xmlDoc.createTextNode("&lt;ProfileroupDescription&gt;&lt;/ProfileDescription&gt;");
        Element childSelectProfileMac3Classified1 = xmlDoc.createElement("select");
        childSelectProfileMac3Classified1.setAttribute("idref", "V-001");
        childSelectProfileMac3Classified1.setAttribute("selected", "true");
        Element childSelectProfileMac3Classified2 = xmlDoc.createElement("select");
        childSelectProfileMac3Classified2.setAttribute("idref", "V-002");
        childSelectProfileMac3Classified2.setAttribute("selected", "true");

        //profile MAC3 Public
        Element mainProfileMac3Public = xmlDoc.createElement("Profile");
        mainProfileMac3Public.setAttribute("id", "MAC-3_Public");
        Element childTitleProfileMac3Public = xmlDoc.createElement("title");
        Text titleProfileMac3PublicText = xmlDoc.createTextNode("III - Administrative Public");
        Element childDescriptionProfileMac3Public = xmlDoc.createElement("description");
        Text descriptionProfileMac3Public = xmlDoc.createTextNode("&lt;ProfileroupDescription&gt;&lt;/ProfileDescription&gt;");
        Element childSelectProfileMac3Public1 = xmlDoc.createElement("select");
        childSelectProfileMac3Public1.setAttribute("idref", "V-001");
        childSelectProfileMac3Public1.setAttribute("selected", "true");
        Element childSelectProfileMac3Public2 = xmlDoc.createElement("select");
        childSelectProfileMac3Public2.setAttribute("idref", "V-002");
        childSelectProfileMac3Public2.setAttribute("selected", "true");

        //profile MAC3 Sensitive
        Element mainProfileMac3Sensitive = xmlDoc.createElement("Profile");
        mainProfileMac3Sensitive.setAttribute("id", "MAC-3_Sensitive");
        Element childTitleProfileMac3Sensitive = xmlDoc.createElement("title");
        Text titleProfileMac3SensitiveText = xmlDoc.createTextNode("III - Administrative Sensitive");
        Element childDescriptionProfileMac3Sensitive = xmlDoc.createElement("description");
        Text descriptionProfileMac3Sensitive = xmlDoc.createTextNode("&lt;ProfileroupDescription&gt;&lt;/ProfileDescription&gt;");
        Element childSelectProfileMac3Sensitive1 = xmlDoc.createElement("select");
        childSelectProfileMac3Sensitive1.setAttribute("idref", "V-001");
        childSelectProfileMac3Sensitive1.setAttribute("selected", "true");
        Element childSelectProfileMac3Sensitive2 = xmlDoc.createElement("select");
        childSelectProfileMac3Sensitive2.setAttribute("idref", "V-002");
        childSelectProfileMac3Sensitive2.setAttribute("selected", "true");

        //Lets build some stuff here
        xmlDoc.appendChild(rootElement);
        rootElement.appendChild(mainStatusDate);
        mainStatusDate.appendChild(statusDate);
        rootElement.appendChild(mainTitleTop);
        mainTitleTop.appendChild(titleTopText);
        rootElement.appendChild(mainDescriptionTop);
        mainDescriptionTop.appendChild(descriptionTopText);
        rootElement.appendChild(mainNoticeTop);
        mainNoticeTop.appendChild(noticeTopText);
        rootElement.appendChild(mainReferenceTop);
        mainReferenceTop.appendChild(childReferenceTopPublisher);
        childReferenceTopPublisher.appendChild(referenceTopPublisherText);
        mainReferenceTop.appendChild(childReferenceTopSource);
        childReferenceTopSource.appendChild(referenceTopSourceText);
        rootElement.appendChild(mainPlainTextTop);
        mainPlainTextTop.appendChild(plainTextTopText);
        rootElement.appendChild(mainVersionTop);
        mainVersionTop.appendChild(versionTopText);

        // MAC -- 1
        rootElement.appendChild(mainProfileMac1Classified);
        mainProfileMac1Classified.appendChild(childTitleProfileMac1Classified);
        childTitleProfileMac1Classified.appendChild(titleProfileMac1ClassifiedText);
        mainProfileMac1Classified.appendChild(childDescriptionProfileMac1Classified);
        childDescriptionProfileMac1Classified.appendChild(descriptionProfileMac1Classified);
        mainProfileMac1Classified.appendChild(childSelectProfileMac1Classified1);
        mainProfileMac1Classified.appendChild(childSelectProfileMac1Classified2);
        rootElement.appendChild(mainProfileMac1Public);
        mainProfileMac1Public.appendChild(childTitleProfileMac1Public);
        childTitleProfileMac1Public.appendChild(titleProfileMac1PublicText);
        mainProfileMac1Public.appendChild(childDescriptionProfileMac1Public);
        childDescriptionProfileMac1Public.appendChild(descriptionProfileMac1public);
        mainProfileMac1Public.appendChild(childSelectProfileMac1Public1);
        mainProfileMac1Public.appendChild(childSelectProfileMac1Public2);
        rootElement.appendChild(mainProfileMac1Sensitive);
        mainProfileMac1Sensitive.appendChild(childTitleProfileMac1Sensitive);
        childTitleProfileMac1Sensitive.appendChild(titleProfileMac1SensitiveText);
        mainProfileMac1Sensitive.appendChild(childDescriptionProfileMac1Sensitive);
        childDescriptionProfileMac1Sensitive.appendChild(descriptionProfileMac1Sensitive);
        mainProfileMac1Sensitive.appendChild(childSelectProfileMac1Sensitive1);
        mainProfileMac1Sensitive.appendChild(childSelectProfileMac1Sensitive2);

        // MAC -- 2
        rootElement.appendChild(mainProfileMac2Classified);
        mainProfileMac2Classified.appendChild(childTitleProfileMac2Classified);
        childTitleProfileMac2Classified.appendChild(titleProfileMac2ClassifiedText);
        mainProfileMac2Classified.appendChild(childDescriptionProfileMac2Classified);
        childDescriptionProfileMac2Classified.appendChild(descriptionProfileMac2Classified);
        mainProfileMac2Classified.appendChild(childSelectProfileMac2Classified1);
        mainProfileMac2Classified.appendChild(childSelectProfileMac2Classified2);
        rootElement.appendChild(mainProfileMac2Public);
        mainProfileMac2Public.appendChild(childTitleProfileMac2Public);
        childTitleProfileMac2Public.appendChild(titleProfileMac2PublicText);
        mainProfileMac2Public.appendChild(childDescriptionProfileMac2Public);
        childDescriptionProfileMac2Public.appendChild(descriptionProfileMac2Public);
        mainProfileMac2Public.appendChild(childSelectProfileMac2Public1);
        mainProfileMac2Public.appendChild(childSelectProfileMac2Public2);
        rootElement.appendChild(mainProfileMac2Sensitive);
        mainProfileMac2Sensitive.appendChild(childTitleProfileMac2Sensitive);
        childTitleProfileMac2Sensitive.appendChild(titleProfileMac2SensitiveText);
        mainProfileMac2Sensitive.appendChild(childDescriptionProfileMac2Sensitive);
        childDescriptionProfileMac2Sensitive.appendChild(descriptionProfileMac2Sensitive);
        mainProfileMac2Sensitive.appendChild(childSelectProfileMac2Sensitive1);
        mainProfileMac2Sensitive.appendChild(childSelectProfileMac2Sensitive2);

        // MAC -- 3
        rootElement.appendChild(mainProfileMac3Classified);
        mainProfileMac3Classified.appendChild(childTitleProfileMac3Classified);
        childTitleProfileMac3Classified.appendChild(titleProfileMac3ClassifiedText);
        mainProfileMac3Classified.appendChild(childDescriptionProfileMac3Classified);
        childDescriptionProfileMac3Classified.appendChild(descriptionProfileMac3Classified);
        mainProfileMac3Classified.appendChild(childSelectProfileMac3Classified1);
        mainProfileMac3Classified.appendChild(childSelectProfileMac3Classified2);
        rootElement.appendChild(mainProfileMac3Public);
        mainProfileMac3Public.appendChild(childTitleProfileMac3Public);
        childTitleProfileMac3Public.appendChild(titleProfileMac3PublicText);
        mainProfileMac3Public.appendChild(childDescriptionProfileMac3Public);
        childDescriptionProfileMac3Public.appendChild(descriptionProfileMac3Public);
        mainProfileMac3Public.appendChild(childSelectProfileMac3Public1);
        mainProfileMac3Public.appendChild(childSelectProfileMac3Public2);
        rootElement.appendChild(mainProfileMac3Sensitive);
        mainProfileMac3Sensitive.appendChild(childTitleProfileMac3Sensitive);
        childTitleProfileMac3Sensitive.appendChild(titleProfileMac3SensitiveText);
        mainProfileMac3Sensitive.appendChild(childDescriptionProfileMac3Sensitive);
        childDescriptionProfileMac3Sensitive.appendChild(descriptionProfileMac3Sensitive);
        mainProfileMac3Sensitive.appendChild(childSelectProfileMac3Sensitive1);
        mainProfileMac3Sensitive.appendChild(childSelectProfileMac3Sensitive2);

        //STIG item
        boolean done = false;
        int counter = 1;
        while (!done) {
            System.out.println("Do you want to make a stig or are you done?");
            String selection = in.nextLine();
            if (selection.equalsIgnoreCase("done")) {
                done = true;
            } else {
                String ruleTitle = ruleTitle();
                String ruleDescription = ruleDescription();
                String fixText = fixText();
                Element mainGroupID = xmlDoc.createElement("Group");
                mainGroupID.setAttribute("id", "V - " + counter);
                Element childTitleGroupID = xmlDoc.createElement("title");
                Text titleGroupIDText = xmlDoc.createTextNode(ruleTitle);
                Element childDescriptionGroupID = xmlDoc.createElement("Description");
                Text descriptionGroupID = xmlDoc.createTextNode("A description of something goes here.");
                Element childRuleID18075 = xmlDoc.createElement("Rule");
                childRuleID18075.setAttribute("id", "Rule - " + counter);
                childRuleID18075.setAttribute("severity", "medium");
                childRuleID18075.setAttribute("weight", "10.0");
                Element babyVersion18075 = xmlDoc.createElement("version");
                Text version18075Text = xmlDoc.createTextNode("Version 1");
                Element babyTitleRuleID18075 = xmlDoc.createElement("title");
                Text titleRuleID18075Text = xmlDoc.createTextNode(ruleTitle);
                Element babyDescriptionRuleID18075 = xmlDoc.createElement("description");
                Text descriptionRuleID18075Text = xmlDoc.createTextNode("A description of the rule goes here, in this case there is no real description because I'm just playing around.");
                Element babyReference01 = xmlDoc.createElement("reference");
                Element ideaDcTitle01 = xmlDoc.createElement("dc:title");
                Text dcTitle01Text = xmlDoc.createTextNode("--");
                Element ideaDcPublisher01 = xmlDoc.createElement("dc:publisher");
                Text dcPublisher01Text = xmlDoc.createTextNode("You can find me on line 173!");
                Element ideaDcType01 = xmlDoc.createElement("dc:type");
                Text dcType01Text = xmlDoc.createTextNode("--");
                Element ideaDcSubject01 = xmlDoc.createElement("dc:subject");
                Text dcSubject01Text = xmlDoc.createTextNode("This is where some sort of subject might go");
                Element ideaDcIdentifier01 = xmlDoc.createElement("dc:identifier");
                Text dcIdentifier01Text = xmlDoc.createTextNode("1176 ---- line 179");
                Element childFixTextRef01 = xmlDoc.createElement("fixtext");
                childFixTextRef01.setAttribute("fixref", "fix_ref" + counter);
                Text fixTextRef01Text = xmlDoc.createTextNode(fixText);
                Element childFixTextRef02 = xmlDoc.createElement("fix");
                childFixTextRef02.setAttribute("id", "fix_ref" + counter);
                Element childCheckSystem01 = xmlDoc.createElement("check");
                childCheckSystem01.setAttribute("system", "C- " + counter);
                Element ideaCheckContent01 = xmlDoc.createElement("check-content-ref");
                ideaCheckContent01.setAttribute("name", "M");
                ideaCheckContent01.setAttribute("href", "XCCDF_" + fileName + ".xml");
                Element ideaCheckContent1 = xmlDoc.createElement("check-content");
                Text checkContent01Text = xmlDoc.createTextNode(ruleDescription);
                counter++;

                // first made up STIG item
                rootElement.appendChild(mainGroupID);
                mainGroupID.appendChild(childTitleGroupID);
                childTitleGroupID.appendChild(titleGroupIDText);
                mainGroupID.appendChild(childDescriptionGroupID);
                childDescriptionGroupID.appendChild(descriptionGroupID);
                mainGroupID.appendChild(childRuleID18075);
                childRuleID18075.appendChild(babyVersion18075);
                babyVersion18075.appendChild(version18075Text);
                childRuleID18075.appendChild(babyTitleRuleID18075);
                babyTitleRuleID18075.appendChild(titleRuleID18075Text);
                childRuleID18075.appendChild(babyDescriptionRuleID18075);
                babyDescriptionRuleID18075.appendChild(descriptionRuleID18075Text);
                childRuleID18075.appendChild(babyReference01);
                babyReference01.appendChild(ideaDcTitle01);
                ideaDcTitle01.appendChild(dcTitle01Text);
                babyReference01.appendChild(ideaDcPublisher01);
                ideaDcPublisher01.appendChild(dcPublisher01Text);
                babyReference01.appendChild(ideaDcType01);
                ideaDcType01.appendChild(dcType01Text);
                babyReference01.appendChild(ideaDcSubject01);
                ideaDcSubject01.appendChild(dcSubject01Text);
                babyReference01.appendChild(ideaDcIdentifier01);
                ideaDcIdentifier01.appendChild(dcIdentifier01Text);
                childRuleID18075.appendChild(childFixTextRef01);
                childFixTextRef01.appendChild(fixTextRef01Text);
                childRuleID18075.appendChild(childFixTextRef02);
                childRuleID18075.appendChild(childCheckSystem01);
                childCheckSystem01.appendChild(ideaCheckContent01);
                childCheckSystem01.appendChild(ideaCheckContent1);
                ideaCheckContent1.appendChild(checkContent01Text);
            }
        }

        //Set OutputFormat
        OutputFormat outFormat = new OutputFormat(xmlDoc);
        outFormat.setIndenting(true);

        //Declare the File 
        File xmlFile = new File("XCCDF_" + fileName + ".xml");

        //Declare the FileOutputStream
        FileOutputStream outStream = new FileOutputStream(xmlFile);

        //XML Serialize to Serialize the XML data with
        XMLSerializer serializer = new XMLSerializer(outStream, outFormat);

        //the specified OutputFormat
        serializer.serialize(xmlDoc);

    }

    public static String stigListTitle() {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the title of this STIG list?");
        String stigListTitle = in.nextLine();
        return stigListTitle;
    }

    public static String listCreationDate() {
        Scanner in = new Scanner(System.in);
        System.out.println("What date was this list created on?");
        String listCreationDate = in.nextLine();
        return listCreationDate;
    }

    public static String ruleTitle() {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the title of the rule?");
        String ruleTitle = in.nextLine();
        return ruleTitle;
    }

    public static String ruleDescription() {
        Scanner in = new Scanner(System.in);
        System.out.println("What is a description of the rule? What is checked?");
        String ruleDescription = in.nextLine();
        return ruleDescription;
    }

    public static String fixText() {
        Scanner in = new Scanner(System.in);
        System.out.println("What is a description of how vulnerabilty item is fixed?");
        String fixText = in.nextLine();
        return fixText;
    }

}