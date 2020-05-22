public void setSlice(double percent, int index){
   Platform.runLater(new Runnable(){
       pieChartData.get(index).setPieValue(percent);
       pieChartData.get(index).setName(caption[index]+"\n"+(int)(percent*100)+"%");
   });
}