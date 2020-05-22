String Cid = "1";
String Tid = "1";

File iFile = new File("Records");
BufferedReader yourfile = new BufferedReader(new FileReader(iFile));
BufferedReader yourfile2 = new BufferedReader(new FileReader(iFile));

int total=0;
String rec=yourfile2.readLine(); 
while (rec != null){    // count total records (rows) 
    total++;
    rec=yourfile2.readLine(); 
}

String dataRow = yourfile.readLine(); 
String[] allTemp[]=new String[total][]; //create array of an array with size of the total record/row
int counter=0;

while (dataRow != null){

    String[] dataArray = dataRow.split(",");

    if(Cid.equals(dataArray[1]) && Tid.equals(dataArray[3]))
        dataRow = yourfile.readLine(); // skip current row if match found
    else{
        allTemp[counter]=dataArray; //if match not found, store the array into another array
        dataRow = yourfile.readLine();
        counter++; //index for allTemp array. note that counter start from zero and no increment if the current row is skipped
       }    
}
FileWriter writer = new FileWriter(iFile); //create new file which will replace the records file. here, all desired records from file already stored in allTemp array
for (String[] arr : allTemp){
     //check nullity of array inside the array(record). 
    if(arr!=null){
        for(int i=0;i<arr.length;i++){
            writer.append(arr[i]);
                if(i<arr.length-1) //add "," in every column except in the last column
                    writer.append(",");
        }
        writer.append(System.getProperty("line.separator"));
    }
}
writer.flush();
writer.close();