import java.util.List;
import java.util.ArrayList;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultSetCountDemo {

    public static void main(String[] args) throws Exception {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/main", "postgres", args.length >= 1 ? args[0] : "" );

        // execute query
        Statement st = con.createStatement();
        boolean b = st.execute("select 14, 'a' union all select 15, 'b'; select 26, 'x' union all select 27, 'y';");

        // collect and count result sets
        List<ResultSet> rsList = new ArrayList<ResultSet>();
        int count = 0;
        if (b) {
            rsList.add(st.getResultSet());
            for (++count; st.getMoreResults(Statement.KEEP_CURRENT_RESULT); ++count)
                rsList.add(st.getResultSet());
        } // end if
        System.out.println(count+" set"+(count == 1 ? "" : "s"));

        // process and close result sets
        for (int s = 1; s <= count; ++s) {
            ResultSet rs = rsList.get(s-1);
            for (int r = 1; rs.next(); ++r) {
                System.out.println("set "+s+" ("+r+","+1+") == "+rs.getInt(1));
                System.out.println("set "+s+" ("+r+","+2+") == "+rs.getString(2));
            } // end for
            rs.close();
        } // end for

        System.exit(0);

    } // end main()

} // end class ResultSetCountDemo