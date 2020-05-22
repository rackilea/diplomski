import javax.swing.* ;
import java.sql.* ;
import java.io.* ;

public class LoadSQLFile {
    public static void main(string args[ ]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String password = JOptionPane.showInputDialog(null, "We need your MySQL Password to run the application. Please enter it here.", " MySQL Password ?", JOptionPane.QUESTION_MESSAGE) ;
                    Class.forName("java.sql.Driver") ;
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MyDB", "root", password) ;
                    Statement stmt = conn.createStatement() ;
                    int i = 0 ;
                    for(i=1;i<=16;i++) {
                        FileReader fr = new FileReader("src//sql_files//BCK"+i+".sql") ;
                        BufferedReader br = new BufferedReader(fr) ;
                        stmt.execute(br.readLine()) ;
                    }
                    stmt.close();
                    conn.close();
                    JOptionPane.showMessageDialog(null, " Records Successfully Inserted into database !", "Success !", 1) ;
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE) ;
                }
            }
        });
    }
}