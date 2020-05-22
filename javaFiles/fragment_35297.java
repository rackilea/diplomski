public class Fajlla {

    File folder;
    FileReader fr;
    BufferedReader br;
    PrintWriter pw;
    public Fajlla(String fld)throws IOException{
        folder = new File(fld);
        if(!folder.isDirectory()){
            throw new IOException("Nuk eshte folder");
        }
        pw = new PrintWriter(new File("C:/Users/Admin/Desktop/dreniii.txt"));
    }

        public int callItOUU() throws IOException{
            return this.countThem(folder);
        }


    public int countThem(File folder){
           int count = 0;
            File [] files = folder.listFiles();
            for (File file : files) {
                  if(file.isDirectory()){
                      count+=countThem(file);
                  }if(file.isFile() && file.canRead()){
                      count++;
                  }
        }
            return count;
    }




        public static void main(String[] args) {

        try {

            Fajlla  f = new Fajlla("C:/Users/Admin/Desktop/New folder");
            int count = f.callItOUU(new File("C:/Users/Admin/Desktop/dreniii.txt"));
            System.out.println(count);
        } catch (IOException ex) {
            Logger.getLogger(Fajlla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}