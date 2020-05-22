import java.util.HashMap;

class Program
{
    public static void main(String[] args)
    {
        String pattern = "Q01 + Q02";
        String result = "";

        HashMap<String, String> vals = new HashMap<>();

        vals.put("Q01", "123");
        vals.put("Q02", "123");

        for(HashMap.Entry<String, String> val : vals.entrySet())
        {
            result = pattern.replace(val.getKey(), val.getValue());
            pattern = result;
        }

        System.out.println(result);

    }
}