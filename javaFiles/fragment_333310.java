public String parse(String d, String u) {

       if (d.isEmpty() || u.isEmpty()){
            return "";
        } else {
            return "not empty"; 
        }
}

public static void main(String[] args)
{
    String d = "hi";
    String u = ""; //empty

    String result = parse(d, u);
    System.out.println(result);

    String d = "hi";
    String u = "bye"

    result = parse(d, u);
    System.out.println(result);
}