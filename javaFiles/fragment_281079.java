//Read file in separate parts and remove commas
while ((sCurrentLine = textReader.readLine()) != null)  {   
    array = sCurrentLine.split(",");
    System.out.print(array[0]);
    System.out.print(array[1]);
    System.out.print(array[2]);
    System.out.println(array[3]);               
}

//enter variables from each line in separate arrays
for (i = 0; i < array.length; i++) {
    id[i] = array[0];
    name[i] = array[1];
    asg1[i] = array[2];
    asg2[i] = array[3];
}