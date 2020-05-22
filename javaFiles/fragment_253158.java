public static void main(String[] args) {
    String input = ".../PaymentGatewayManager?mode=5015&test=456123&test2=SomeRandomValue&abc=78";
    if(input.contains("?")){
        System.out.println("It does contain parameters");
        input = "&" + input.substring(input.indexOf("?")+1) + "&";

        System.out.println(input);

        Pattern p = Pattern.compile("&?(\\w.+?)=(.+?)&");
        Matcher m = p.matcher(input);

        while(m.find()){
            System.out.println("Token ->" + m.group(1));
            System.out.println("Value ->" + m.group(2));
        }
    }
}