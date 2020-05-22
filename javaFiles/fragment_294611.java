public static void main(String[] args) {
    String[][] array = new String[3][3]; //My array of test
    for(int i = 0; i < 9; ++i){
        array[i/3][i%3] = "#" + i;
    }

    Scanner sc = new Scanner(System.in); //A scanner to way my input
    for(String[] tmp : array){
        System.out.print("Press ENTER to continue");
        sc.nextLine(); //I am read, press "ENTER" to write in file
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            fw = new FileWriter("test.txt",false);
            bw= new BufferedWriter(fw);
            for(String s : tmp){
                bw.write(s);
                bw.newLine();
            }
        }
        catch(IOException e){}
        finally{
            if (bw != null) {
                try {
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}