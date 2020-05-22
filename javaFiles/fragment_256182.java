public static void main(String[] args) {
        String s = args[0].toString();
        System.out.println("=>" + s);
        try {
            JSONObject json = (JSONObject) new JSONParser().parse(s);
            System.out.println(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }