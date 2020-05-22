**Try this just copy and paste it in your public class**

    public static void main(String... args)
    {
        Map<String,String> myMap = new HashMap<String,String>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name;");
        String firstName = sc.next();
        myMap.put("firstName",firstName);


        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter your lastName;");
        String lastName = sc1.next();
        myMap.put("lastName",lastName);

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter your email;");
        String email = sc2.next();
        myMap.put("email",email);

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter your mobile;");
        String mobile = sc3.next();
        myMap.put("mobile",mobile);


        try {
            JSONObject jsonObject = new JSONObject(myMap.toString());
            System.out.println(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }