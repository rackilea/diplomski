public class GUIThread {
    static Connection con; 
    static Statement stmt; 
    static ResultSet rs;
    int curRow = 0;

    public static void DoConnect(){
        try{
            String host = "jdbc:derby://localhost:1527/Mariel";
            String uName = "mariel";
            String uPass = "1234";
            con = DriverManager.getConnection(host, uName, uPass);

            stmt = con.createStatement();
            String SQL = "SELECT * FROM LETTER";
            rs = stmt.executeQuery(SQL);

            class printLetter extends TimerTask {
                @Override
                public void run() {
                    try {
                        rs.next();
                        final String letter;
                        letter = rs.getString("LETTER");
                        System.out.println(letter);
                    } catch (SQLException ex) {
                        DoConnect();
                    }
                }
            }
            Timer timer = new Timer();
            timer.schedule(new printLetter(), 0, 2000);
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }

    public static void main(String args[]){
        DoConnect();
    }
}