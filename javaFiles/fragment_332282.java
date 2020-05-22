public class Testing{
    public static void main(String args[]){
        for(int i = 0; i < Integer.MAX_VALUE; i++){
            System.out.println(i+" "+(char)i);
            if(i == 270){
                break;
            }
        }
    }
}