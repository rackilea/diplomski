package customer;
import java.io.*;
import java.util.*;
import java.sql.*;

public class Customer implements Serializable
{

        private String custID;
        private String custName;
        private int qty;
        private float price;
        private float total;
        private int storeCust;

        public String getCustID() {
            return custID;
        }

        public void setCustID(String custID) {
            this.custID = custID;
        }

        public String getCustName() {
            return custName;
        }

        public void setCustName(String custName) {
            this.custName = custName;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public float getTotal() {
            return total;
        }

        public void setTotal(float total) {
            this.total = total;
        }

        public int setStoreCust() 
        {
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usermaster","admin","password");
            PreparedStatement pstmt=null;
            String query=null;
            query="insert into customer values(?,?,?,?,?)";
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,custID);
            pstmt.setString(2,custName);
            pstmt.setInt(3,qty);
            pstmt.setFloat(4,price);
            pstmt.setFloat(5,total);
            int i=pstmt.executeUpdate();

            this.storeCust=i;
            }
            catch(Exception e)
            {

            }
            return storeCust;
        }
}