File f = new File("path_to_file.txt");
BufferedReader br;
String text = "";
try {
     br= new BufferedReader(new FileReader(f));
     String line;
     while((line = br.readLine())!=null){
         text+=line;
     }
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
if(text.equals("started")){
    // we have to make sure it can work next time so we clear the file's contents
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("");
        bw.flush();
        bw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    //close launcher
}