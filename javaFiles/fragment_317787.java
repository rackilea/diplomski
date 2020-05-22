// Initialize and provide dummy input.
int requiredIndex = 5;
    ArrayList<String> results = new ArrayList<String>();
    csvToArray("some,column,data,with,seven,columns,only", results, requiredIndex);
    csvToArray("more,data,that,came, in, just, now , and is, longer", results, requiredIndex);
    csvToArray("a, short, line", results, requiredIndex);
    csvToArray("last, line, of, input, which, is, correct.", results, requiredIndex);
    System.out.println(results);
    // output : [columns, just, is]

// Update the method as below.
public static void csvToArray(String csvData, ArrayList<String> results, int index){
    if (csvData != null){
        String[] splitData = csvData.split(",");
        int wordCount = 0;
        if(splitData.length < index)
            return;
        for(int i = 0; i < splitData.length; i++){
            if(!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                ArrayList<String> individualList = new ArrayList<String>();
                individualList.add(splitData[i].trim());
                if(wordCount == index)
                    results.add(splitData[i].trim());
                wordCount++;
            }
        }
    }
}