//if you have the brackets remaining and don't want them, remove them
data = data.replace("[","").replace("]","");


String data = "data1,data2,data3";
//You would put the second parameter as -1 if you want to keep any trailing blank values 
List<String> smapleData= Arrays.asList(data.split(",",-1));
//or if you don't want to keep trailing blanks
List<String> sampleDataTwo = Arrays.asList(data.split(","));