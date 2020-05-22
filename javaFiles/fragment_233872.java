try{
  out = new BufferedWriter(new FileWriter(textFile));

 for (LeaderProfile leader: leaders){
    out.write(leader.printCSVData() +"\n");
 }
 out.close();
}
catch(Exception e){
    e.printStackTrace();
}