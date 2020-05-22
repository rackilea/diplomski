BufferedReader br = new BufferedReader(new FileReader(selectFile.getSelectedFile()));

String recTime, peakName, amount, sample ;
int linesToSkip = 28;
String line = br.readLine();

if(line != null){
    String[] values = line.split("\t");
    sample = values[1];
}

while ( (line = br.readLine()) != null) {
    values = line.split("\t");

    if (line.startsWith("Sample Name")) { 
       // Check here value[1] is equal to sample. If this is needed.
       // You got your sample name here 
    } else if (line.startsWith("Recording Time")) { 
       recTime = values[1];
       // You got your Recording Time here 
    } else if(values.length > 4 ){
       // get Peak Name and recording time
       peakName = values[2];
       amount = values[6];
    } else if (line.contains("n.a.") || line.contains("Total") || linesToSkip-- > 0) {
       /* may not needed linesToSkip-- > 0 in above condition */ 
       continue;
    } 

    System.out.println(sample +" ," + recTime + " ," + peakName + " ," + amount);
}