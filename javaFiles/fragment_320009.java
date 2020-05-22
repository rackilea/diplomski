for (String line1 : lines) {
String[] array = null;
array = line1.split("\\|",-1);

for(int i = 1 ;i<array.length-1;i++){
listOfData.add(array[i]);
}}

System.out.println(listOfData);