import com.ximpleware.*;
public class simpleRead {
    public static void main(String s[]) throws VTDException{
        VTDGen vg = new VTDGen();
        if (!vg.parseFile("d:\\xml\\title.xml", false)){
            return;
        }
        VTDNav vn = vg.getNav();
        AutoPilot ap = new AutoPilot(vn);
        ap.selectXPath("/title/program/text/text()");
        int i=0;
        while((i=ap.evalXPath())!=-1){
            System.out.print(" "+vn.toString(i));
        }
    }
}