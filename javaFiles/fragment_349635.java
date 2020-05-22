public class FetchData2 {

   public static Connection getConnection() {

      System.out.println("initial connection "+connection); 

      // DB Connection
      Connection connection = null;
      try {
            System.out.println("i am inside connection");             
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("connection");
            System.out.println("Connection estabilished"+connection);
      } catch (Exception e) {
            System.out.println("Connection error1: "+e);
      } 
      return connection;
   }
}

public static ArrayList<Elements2> getAllElements2 (String sino,String irepno) {        
    ArrayList<Elements2> itemListinsp = new ArrayList<Elements2>();     

    try (Connection connection = FetchData2.getConnection();
         Statement statement1 = connection.createStatement();
         ResultSet rs = statement1.executeQuery("query1")) {

        while(rs.next()) {  
            Elements2 iteminsp = new Elements2();   
            iteminsp.setParameters(rs.getString("parameters"));
            iteminsp.setSpecifications(rs.getString("specifications"));
            iteminsp.setActual1(rs.getString("actual1"));
            iteminsp.setActual2(rs.getString("actual2"));
            iteminsp.setActual3(rs.getString("actual3"));
            iteminsp.setActual4(rs.getString("actual4"));
            iteminsp.setActual5(rs.getString("actual5"));
            itemListinsp.add(iteminsp);
        }          
    } catch (Exception e) {
        System.out.println("Connection query exection error: "+e);
    }
    return itemListinsp;
}

public static ArrayList<Elements2> getcritElements2(String icode) {
    System.out.println("I AM IN SECOND FETCH");
    ArrayList<Elements2> listcrit = new ArrayList<Elements2>();

    System.out.println("incoming icode: "+icode);

    try (Connection connection = FetchData2.getConnection();
         Statement statementinsp = connection.createStatement();
         ResultSet rsinsp = statementinsp.executeQuery("query2")) {

        if (!rsinsp.isBeforeFirst() ) {
            System.out.println("no data");
        } 

        while(rsinsp.next()) {  
            Elements2 inspcrit=new Elements2(); 
            inspcrit.setParameters(rsinsp.getString("parameters"));
            inspcrit.setSpecifications(rsinsp.getString("specifications"));
            listcrit.add(inspcrit);
        }            
    } catch (Exception e) {
        System.out.println("Connection query exection error: "+e);
    }
    System.out.println(listcrit.size());
    System.out.println(listcrit.get(0).getParameters());
    System.out.println(listcrit.get(0).getSpecifications());
    return listcrit;
}