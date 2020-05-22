private void process(){
    BufferedReader bufferedReader = null;
    PrintWriter p = null;
    String sep = ",";
    String newCol = "monthsTill";
    String defaultTillExpMonth = ">3";
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    int currMonth = cal.get(Calendar.MONTH) + 1;
    try {
    // read csv file
    List<String> input = new ArrayList<String>();
   File inputFile = new File("InputFile");
  bufferedReader = new BufferedReader(new FileReader(inputFile));
    String readLine = "";
    while ((readLine = bufferedReader.readLine()) != null) {
        input.add(readLine);
    }

 // for each row after first row
    // calculate timeTillExpired
        // if format MYYYY (ex 22017)
            // M and YYYY -> MM and YYYY

       // calculate relative to current date as months

    int numOfRecords = input.size();
    if(numOfRecords>1){
        List<String> output = new ArrayList<String>();
        String header = input.get(0) +sep +newCol;
        output.add(header);

        // for each row after first row
        // calculate timeTillExpired
        // if format MYYYY (ex 22017)
              // M and YYYY -> MM and YYYY
        // calculate relative to current date as months
        for(int i=1;i<numOfRecords;i++){
            // I am simply going to get the last column from record
            String row = input.get(i);
            StringBuilder res = new StringBuilder(row);
            String [] entries = row.split(sep);
            int length = entries.length;
            if(length>0){
                res.append(sep);
                String rec = entries[length-1];
                int expMonth = 0;
                // Case of MYYYY. Assumption is it's either MYYYY or MMYYYY
                if(rec.length()==5){
                    expMonth = Integer.valueOf(rec.substring(0, 1));
                } else {
                    expMonth = Integer.valueOf(rec.substring(0, 2));
                }

                int monToExp = expMonth - currMonth;
                // if calculated > 3
                if(monToExp > 3){
                    res.append(defaultTillExpMonth);
                } else {
                    res.append(monToExp);
                }
                output.add(res.toString());
            }
        }
        // Write into the same file.
        // First We'll delete everything in the input file and then write the modified records

        p = new PrintWriter(new FileWriter("output.txt",false));
        // Ouch. Very bad way to handle resources. You should find a better way
        p.print("");
        p.close();
        // Write into file
        p = new PrintWriter(new FileWriter("InputFile"));
        for(String row : output)
        {
            p.println(row);
        }



    } else {
        System.out.println("No records to process");
    }



    } catch(IOException e){
        e.printStackTrace();
    } finally { // Close file
        if(p!=null){
            p.close();
        }
        if(bufferedReader!=null){
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}