import java.util.Random;

class proyecto{
    public static void main(String[]args){
        Random numb = new Random();
        if(args.length>0){
            System.out.println(numb.nextInt(Integer.parseInt(args[0].toString()));
        }
    }
}