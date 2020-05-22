import com.ximpleware.*;
import java.io.*;

public class simpleMod {
    public static void main(String s[]) throws VTDException,IOException{
        VTDGen vg = new VTDGen();
        if (!vg.parseFile("input.xml", false))
            return;
        VTDNav vn = vg.getNav();
        XMLModifier xm = new XMLModifier(vn);
        AutoPilot ap = new AutoPilot(vn),ap2=new AutoPilot(vn);
        ap.selectXPath("/employees/employee[@ID='1']/Salary");
        ap2.selectXPath("../../employee[@ID='2'");
        int i=ap.evalXPath();
        if (i==-1)
            return; 
        xm.insertAfterElement("<Address>10th cross, Park Avenue</Address>");
        i=ap2.evalXPath();
        if (i==-1)
            return;
        xm.insertAfterElement(" <Employee ID=\"3\">\n<Firstname>Holly</Firstname>\n<Lastname>Becker</Lastname>\n<Age>24</Age>\n<Salary>30000</Salary>\n</Employee>");
        xm.output("output.xml");

    }
}