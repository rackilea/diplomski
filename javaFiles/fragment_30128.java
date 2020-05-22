import java.util.Date;
import org.apache.poi.openxml4j.opc.*;
import org.apache.poi.openxml4j.util.Nullable;

class SetDOCXMetadata{
  public static void main(String[] args){
      try{
          OPCPackage opc = OPCPackage.open("metadata.docx");
          PackageProperties pp = opc.getPackageProperties();

          Nullable<String> foo = pp.getLastModifiedByProperty();
          System.out.println(foo.hasValue()?foo.getValue():"empty");
          //Set some properties
          pp.setCreatorProperty("M Kazarian");
          pp.setLastModifiedByProperty("M Kazarian " + System.currentTimeMillis());
          pp.setModifiedProperty(new Nullable<Date>(new Date()));
          pp.setTitleProperty("M Kazarian document");

          opc.close();
      } catch (Exception e) {}
  }
}