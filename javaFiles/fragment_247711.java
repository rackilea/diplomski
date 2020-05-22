import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQSequence;

import oracle.xml.xquery.OXQDataSource;

public class HelloWorld {

    public static void main(String[] args) throws XQException {
        OXQDataSource ds = new OXQDataSource();
        XQConnection con = ds.getConnection();
        String query = "<hello-world>{1 + 1}</hello-world>";
        XQPreparedExpression expr = con.prepareExpression(query);
        XQSequence result = expr.executeQuery();

        // prints "<hello-world>2</hello-world>"
        System.out.println(result.getSequenceAsString(null));

        result.close();
        expr.close();
        con.close();
    }

}