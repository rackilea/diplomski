public class Test
{
    public static long calculate(long n)
    {   
        return n;
    }   
    public static void main(String[] args)
    {       
        long answer = 0L;
        try{
            answer = calculate(Long.parseLong(args[0]));
        }catch (ArrayIndexOutOfBoundsException ae){
            ae.printStackTrace();
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
        System.out.println(answer);      
    }   
}