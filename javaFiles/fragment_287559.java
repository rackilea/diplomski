import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import org.sqlite.*;
import java.util.ArrayList;
import java.util.List;


public class AccessAgenda {
    public ArrayList<Activite> getActivites() throws Exception {
        ArrayList<Activite> activitelist = new ArrayList<Activite>();
        ActiviteBD db = new ActiviteBD();
        Connection con = db.getConnection();
        System.out.println(con);
        System.out.println("dans getactivites()");
        activitelist = getActivites(con);
        return activitelist;
    }

        public ArrayList<Activite> getActivites(Connection con) throws SQLException {
        ArrayList<Activite> activitelist = new ArrayList<Activite>();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM activite;");
        System.out.println(stmt);
        ResultSet rs = stmt.executeQuery();
        System.out.println(rs);

            while (rs.next()) {
                System.out.println("entrée2");
                Activite activiteobj = new Activite();
                activiteobj.setJour(rs.getInt("jour"));
                activiteobj.setMois(rs.getInt("mois"));
                activiteobj.setAnnee(rs.getInt("annee"));
                activiteobj.setBut(rs.getString("but"));
                activiteobj.setpart_journee(rs.getInt("part_journee"));
                activiteobj.setLieu(rs.getString("lieu"));
                activitelist.add(activiteobj);
            }
            rs.close();
            stmt.close();
            con.close();

        return activitelist;

    }


}