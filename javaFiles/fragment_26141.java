public class ReadFile {
    Scanner x = null;

    public ReadFile() {
        try{
            x = new Scanner(new FileInputStream(
                    "C:\\Users\\Rohan Vidyarthi\\workspace\\Data.csv"));
        }
        catch(FileNotFoundException e){
            System.out.println("File not found error");
        }
    }

    public void readFile(){
        //add code
    }

    public void skipFirst(){
        //add code
    }

    public String[] getData(){
        //add code
    }

    public boolean checker(){
        return x.hasNextLine();
    }

    public void closeFile(){
        x.close();
    }
  }