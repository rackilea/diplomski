public static void main(String[] args) {
    String fileName="/home/Csvfile.csv";
    try {
      BufferedReader br = new BufferedReader( new FileReader(fileName));
      String strLine = null;
      StringTokenizer st = null;
      int lineNumber = 0, tokenNumber = 0;
      while( (fileName = br.readLine()) != null)
      {
        lineNumber++;
        //break comma separated line using ","
        st = new StringTokenizer(fileName, ",");
    System.out.print("\n" + lineNumber + " | ");    
        while(st.hasMoreTokens())
        {
          //display csv values
          tokenNumber++;
          System.out.print(st.nextToken()+" | ");
        }
        //reset token number
        tokenNumber = 0;
      }
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }