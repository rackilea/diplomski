import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.ejb.test.pckg.ICalcRemote;

public class Main {
    public static void main(String[] args) {

        try {

            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

            Context ctx = new InitialContext();
            ICalcRemote calc = (ICalcRemote) ctx.lookup("java:global/EJBDemo/CalcBean!com.ejb.test.pckg.ICalcRemote");

            System.out.println(calc.add(5, 43));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * (non-Java-doc)
     *
     * @see java.lang.Object#Object()
     */
    public Main() {
        super();
    }

}