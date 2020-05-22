import com.ximpleware.*;
public class queryAttr {
    public static void main(String[] s) throws VTDException{
        VTDGen vg = new VTDGen();
        vg.selectLcDepth(5);// improve XPath performance for deep document
        if (!vg.parseFile("input.xml", false))
            return;
        VTDNav vn = vg.getNav();
        AutoPilot ap = new AutoPilot(vn);
        ap.selectXPath("/BatchItemFullInfoAnswer/Result/Item/ConfiguredItems/OtapiConfiguredItem/Configurators/ValuedConfigurator/@pid");
        AutoPilot ap2 = new AutoPilot(vn);
        ap2.selectXPath("../@vid");
        int i=0,j=0;
        while((i=ap.evalXPath())!=-1){
            System.out.println(" attr value for pid is ==>"+vn.toString(i+1)); // notice this is i+1, not i cuz i is the vtd record index for pid
            vn.push();// maintain consistency of autoPilot with push/pop combo
            if ((j=ap2.evalXPath())!=-1)
                System.out.println(" attr value for vid is ==>"+vn.toString(j+1)); // notice this is j+1, not j cuz j is the vtd record index for vid
            vn.pop();
        }
    }
}