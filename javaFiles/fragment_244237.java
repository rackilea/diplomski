List<String> graphData=new ArrayList<String>();
int i = 0;
while(rs.next()){
  i++;
  graphData.add(rs.getString("TIME"));
  graphData.add(df.format(rs.getFloat("BID")));
  graphData.add(df.format(rs.getFloat("ASK")));

  if(i>=5){
    double sum, avg = 0;
    for (int arr=i*3-13; arr<i*3-1; arr+=3) {
      sum = sum+graphData.get(arr));
    }
    avg = sum/5;
    System.out.println(avg );
  }
}