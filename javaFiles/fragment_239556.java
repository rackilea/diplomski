import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class JRMinoltaAspect {        

    @Before("execution(int net.sf.jasperreports.engine.print.JRPrinterAWT.print(java.awt.Graphics, java.awt.print.PageFormat , int )) && args(g, pf, ..)")
    public void scalePrint(Graphics g, PageFormat pf){
        if(pf.getOrientation() == PageFormat.LANDSCAPE){
            g.translate(0, (int)pf.getHeight() / 2 );
        }
        ((Graphics2D)g).scale(0.5, 0.5);        
    }

}