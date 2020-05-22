finalQuery = "SELECT  TransDate FROM abc.`" + str_date + "` WHERE `Id`='" + Id 

for(int i=1;i<dates.size();i++){
   Date lDate =(Date)dates.get(i);
   ds = formatter.format(lDate);    


  for(int i=0;i<s;i++) {
      query1 = "SELECT  TransDate FROM mis.`" + ds + "` WHERE `Id`='" + Id + "'";

  }
   finalQuery = finalQuery + " " + " union all " + " " + query1;
}