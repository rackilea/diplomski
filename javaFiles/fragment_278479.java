public class Read_File {
private FileReader fr;

public static String read(String file_name){
String fileName=System.getProperty("user.dir")+"/src/resources/data_files/"+file_name+".txt";
String client_number = null;
try{
    FileReader inputFile = new FileReader(fileName);
    BufferedReader bufferReader = new BufferedReader(inputFile);

   client_number = bufferReader.readLine();
   System.out.print("client number "+client_number);
   bufferReader.close();


} catch (FileNotFoundException e) {
    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
} catch (IOException e) {
    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
}
    return client_number;
}
public Read_File (FileReader fr) {
    this.fr = fr;

}
}