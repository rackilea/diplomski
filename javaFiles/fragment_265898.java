//String feature=rs.getString("getvaluesfromDB");
    String feature="Games-About Myself,Intro About Myself";
    String [] b = feature.split("[\\-:\\;:\\,]");
    StringBuffer sbf = new StringBuffer();
    for(int i=0;i<b.length;i++) {

        ResultSet rs2 = st2.executeQuery("select * from videonameslist where videoname='"+b[i]+"'");

        if(rs2.next()) {
            if(sbf.length()==0){
                sbf.append("<a href='GameplayfromPlanner.jsp?sno="+b[i]+"' title='Click and Play this Game!' id='id' onclick='getIdforplaygame(this.id)'>").append(b[i]).append("</a>").append(" ");
            }else{
                sbf.append("<a href='GameplayfromPlanner.jsp?sno="+b[i]+"' title='Click and Play this Game!' id='id' onclick='getIdforplaygame(this.id)'>").append(",").append(b[i]).append("</a>").append(" ");
            }
        } else {
            if(sbf.length()==0){
                sbf.append(b[i]).append(" ");
            }else{
                sbf.append(",").append(b[i]).append(" ");
            }
        }  
        /*
         * No Need to remove commas
         * System.out.println("befor  remove comma :"+sbf1);
        String sbf1 = sbf.toString();  
        if (sbf1.endsWith(",")) {
            sbf1 = sbf1.substring(0, sbf1.length() - 1); 
            System.out.println("after removing comma, the string is :"+sbf1);
        } else {
            System.out.println("Sorry there some proble in removing! :"+sbf1);
        }*/
}   
System.out.println("final sbf-->"+sbf);