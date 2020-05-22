import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;
import javax.xml.bind.*;

public class JaxbTest {

   private static final String RESOURCE_NAME = "data.txt";

   public static void main(String[] args) {
      // marshallTest();

      unmarshallTest();
   }

   private static void unmarshallTest() {
      JAXBContext context;
      try {
         context = JAXBContext.newInstance(RtSuperQuickMetadata.class);
         Unmarshaller unmarshaller = context.createUnmarshaller();
         RtSuperQuickMetadata metaData = (RtSuperQuickMetadata) unmarshaller
               .unmarshal(JaxbTest.class.getResourceAsStream(RESOURCE_NAME));
         System.out.println(metaData);
      } catch (JAXBException e) {
         e.printStackTrace();
      }
   }

   private static void marshallTest() {
      RtSuperQuickMetadata data = new RtSuperQuickMetadata();
      List<RtSuperQuickMetadataItem> metaItemList = new ArrayList<RtSuperQuickMetadataItem>();
      RtSuperQuickMetadataItem metaDataItem = new RtSuperQuickMetadataItem();
      List<FileNumber> fileNumbers = new ArrayList<FileNumber>();
      fileNumbers.add(new FileNumber("123"));
      fileNumbers.add(new FileNumber("124"));
      fileNumbers.add(new FileNumber("125"));
      fileNumbers.add(new FileNumber("126"));
      metaDataItem.setFileNumbers(fileNumbers);
      metaItemList.add(metaDataItem);
      data.setRtSuperQuickMetadataItems(metaItemList);
      JAXBContext context;
      try {
         context = JAXBContext.newInstance(RtSuperQuickMetadata.class);
         Marshaller marshaller = context.createMarshaller();
         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

         marshaller.marshal(data, System.out);

      } catch (JAXBException e) {
         e.printStackTrace();
      }
   }
}

@XmlRootElement(name = "contentFiles")
class RtSuperQuickMetadata {
   private List<RtSuperQuickMetadataItem> rtSuperQuickMetadataItems;

   @XmlElement(name = "contentFile")
   public final List<RtSuperQuickMetadataItem> getRtSuperQuickMetadataItems() {
      return rtSuperQuickMetadataItems;
   }

   public void setRtSuperQuickMetadataItems(
         List<RtSuperQuickMetadataItem> rtSuperQuickMetadataItems) {
      this.rtSuperQuickMetadataItems = rtSuperQuickMetadataItems;
   }

   @Override
   public String toString() {
      return "RtSuperQuickMetadata [rtSuperQuickMetadataItems="
            + rtSuperQuickMetadataItems + "]";
   }

}

class RtSuperQuickMetadataItem {

   private List<FileNumber> fileNumbers;

   public RtSuperQuickMetadataItem() {
      fileNumbers = new ArrayList<FileNumber>();
   }

   @XmlElement(name = "fileNumbers")
   public List<FileNumber> getFileNumbers() {
      return fileNumbers;
   }

   public void setFileNumbers(List<FileNumber> fileNumbers) {
      this.fileNumbers = fileNumbers;
   }

   @Override
   public String toString() {
      return "RtSuperQuickMetadataItem [fileNumbers=" + fileNumbers + "]";
   }

}

@XmlRootElement(name = "fileNumber")
class FileNumber {
   private String fileNumber;

   public FileNumber() {}

   public FileNumber(final String fileNumber) {
      this.fileNumber = fileNumber;
   }

   // @XmlElement(name = "fileNumber")
   public final String getFileNumber() {
      return fileNumber;
   }

   public final void setFileNumber(final String fileNumber) {
      this.fileNumber = fileNumber;
   }

   @Override
   public final String toString() {
      return fileNumber;
   }
}