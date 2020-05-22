catch (SQLException se) {

      do {

         if(se.getSQLState().equals("28502")){
            System.out.println("Username Problem");
         }

         else{
            System.out.println("Other Problem");
         }  

      } while ((se = se.getNextException()) != null);

}