public class ConnectionClass {


        public Connection connectDb() {

            Connection con=null;
            try {
                Class.forName("com.mysql.jdbc.Driver");  
                 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","root");  
            }catch (Exception e) {
                con=null;
            }

            if(con!=null)
                System.out.println("connected");
            else
                System.out.println("not connected");

            return con;
        }
    }