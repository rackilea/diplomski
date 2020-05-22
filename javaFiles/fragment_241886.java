public static void main(String[] args) throws Exception{

    File f = new File("abc.txt");
    FileReader fr = new FileReader(f);
    int count = 0;
    while(fr.read()!=-1){
        count++;
    }
    fr.close();

    FileWriter fw = new FileWriter(f);
    while(count-->0){
        fw.write('*');
    }
    fw.flush();     
    fw.close();
}