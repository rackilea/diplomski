import com.jacob.activeX.*;
import com.jacob.com.*;

public class testJacob {
  public static void main(String args[]) {
    String sMoniker = "winmgmts:{impersonationLevel=impersonate}!" +
      "\\\\.\\root\\cimv2";
    Dispatch dServ = new Dispatch(sMoniker);
    Variant v = Dispatch.call(dServ, "SubclassesOf");
    // SWbemObjectSet object
    // http://msdn.microsoft.com/en-us/library/aa393762%28v=vs.85%29.aspx
    Dispatch objSet = v.getDispatch();
    System.out.println("object count: " + objSet.get(objSet, "count"));
    int cObj = 0;
    EnumVariant en = new EnumVariant(objSet);
    while (en.hasMoreElements()) {
      // SWbemObject object
      // http://msdn.microsoft.com/en-us/library/aa393741(v=vs.85).aspx
      Dispatch dItem = en.nextElement().getDispatch();
      Dispatch dPath = Dispatch.get(dItem, "Path_").getDispatch();
      String sClass = Dispatch.get(dPath, "Class").getString();
      System.out.println("path: " + sClass);
      Dispatch dObj = Dispatch.call(dServ, "get", sClass).getDispatch();
      Dispatch dProps = Dispatch.call(dObj, "Properties_").getDispatch();
      EnumVariant enProp = new EnumVariant(dProps);
      while (enProp.hasMoreElements()) {
        Dispatch dProp = enProp.nextElement().getDispatch();
        String sProp = Dispatch.get(dProp, "name").getString();
        System.out.println("property: " + sProp);
      }
      if (++cObj >= 5)
        break;
    }
  }
}