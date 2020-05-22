public void ExtractBoard() throws IOException, SQLException {
    int rows = 0;
    String sqlInser = "INSERT INTO APP.SUBSCRIBERBR (subID, boardno)"+"VALUES (?,?)";
    PreparedStatement  stmt = conn.prepareStatement(sqlInser, Statement.RETURN_GENERATED_KEYS);
    String[] AryFiles2 = rf.OpenFile();
    int i,j;
    String p1=null , p2=null;
    for (i=0; i<AryFiles2.length; i++) {
        if (AryFiles2[i].contains("ADD VSBR")) {
            String[][] parts = this.LineParts();
            Scanner in = new Scanner(parts[i][0]).useDelimiter("[^0-9]+");
            int intst = in.nextInt();
            p1 = String.valueOf(intst);
            for (j=0; j<parts[1].length; j++) {
               if (parts[i][j].contains("MN")) {
                   Scanner inn = new Scanner(parts[i][j]).useDelimiter("[^0-9]+");
                   int intstr = inn.nextInt();
                   p2 = String.valueOf(intstr); 

               }
           }
       }
       if(p1 != null && p2 != null){
           stmt.setString(1, p1);
           stmt.setString(2,p2);
           rows += stmt.executeUpdate();
       }
       else{
           \\throw an exception or do what you want
       }
   }
}