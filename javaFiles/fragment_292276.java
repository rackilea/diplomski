public class LambdaStackTrace 
{
    public static void main(String[] args) throws Exception 
    {
        "a".chars().forEach(c -> {
            new Error().printStackTrace();
        });
    }
}