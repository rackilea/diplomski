//create the two lists before loop starts.
ArrayList<String> list1 = new ArrayList<String>();
ArrayList<String> list2 = new ArrayList<String>();

while (( line = bf.readLine()) != null)
{
    linecount++;
    int indexfound = line.indexOf(dcp);

    if (indexfound > -1) {
        //place your code here

        //add the two elements to their respective list
        list1.add(line.substring(6,10));
        list2.add(line.substring(15,19).trim());

        System.out.println(line.substring(6,10) + " " + line.substring(15,19).trim());
    }
}