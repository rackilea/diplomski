btnShow.setOnAction(e->{

    String finalList="";
    for (int sub=0;sub<finalArrayList.size();sub++){
        Worker worker=finalArrayList.get(sub);
        finalList+=worker.getName()+"\t";
        finalList+=worker.getCity()+"\n";
    }
    StageTwo(finalList); 

});