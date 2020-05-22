import com.ximpleware.*;
public class queryAttr {
    public static void main(String[] s) throws VTDException{
        VTDGen vg = new VTDGen();
        vg.selectLcDepth(5);// improve XPath performance for deep document
        if (!vg.parseFile("input.xml", false))
            return;
        VTDNav vn = vg.getNav();
        AutoPilot ap = new AutoPilot(vn);
        ap.selectXPath("/BatchItemFullInfoAnswer/Result/Item/ConfiguredItems/OtapiConfiguredItem/Configurators/ValuedConfigurator");
        int i=0,j=0;
        while((i=ap.evalXPath())!=-1){
            j= vn.getAttrVal("pid");
            if (j!=-1)
                System.out.println(" attr value for pid is ==>"+vn.toString(j));
            j= vn.getAttrVal("vid");
            if (j!=-1)
                System.out.println(" attr value for vid is ==>"+vn.toString(j));
        }
    }
}