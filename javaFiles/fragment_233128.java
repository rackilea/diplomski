public static void Write() throws Exception {
    String line, lineCut;
    BufferedReader br = null;  //initialise BR- reads text from file
    BufferedWriter bw = null;  //initialise BR- writes text to file
    try
    {
        br = new BufferedReader(new       FileReader("/Users/jbloggs/Documents/input.txt")); //input file
        bw = new BufferedWriter(new FileWriter("/Users/jbloggs/Desktop/output.txt"));   //output file

        line = br.readLine(); // declare string equal to each line
        float sum = 0;
        int counter = 0;  

        while(line != null) { // iterate over each line 

            lineCut = line.replaceAll(";" , ",");  
            sum += Float.parseFloat(lineCut);
            counter++;

            bw.write(lineCut); // write each line to output file
            bw.write("\n");    // print each line on a new line
            line = br.readLine();
        }

        bw.write("Average = ");  
        bw.write(sum / counter);
        bw.write("\n");

        System.out.println("success"); //print if program works
        br.close();
        bw.close();
    }

    catch(Exception e){
        throw(e); // throw exception
    }
  }
}