public void readFile(String path){


File f = new File(path);
FileReader fr = new FileReader(f);
BufferedReader br = new BufferedReader(fr);

String read = new String();

String temRead = new String();

while((temRead = br.readLine())!=null){

     read = read + temRead;

 }



}