public class FirstIO{
static BufferedReader comein;

public FirstIO(){
    try {
    comein= new BufferedReader(new FileReader("C:\Users\HP\Desktop\vocab.txt"));
    } catch(IOException ioe){
        System.out.println("File Not Found");
    }
}
public static void main(String[] args){

    FirstIO l= new FirstIO();
    System.out.println(comein);
}