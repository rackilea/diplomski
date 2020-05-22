public static void main(String[] args) {
        // TODO Auto-generated method stub
        int count=0;
        String password="a34A43";

       boolean hasUppercase = !password.equals(password.toLowerCase());
       boolean hasLowercase = !password.equals(password.toUpperCase());

        if(hasUppercase)
            count++;
        if(hasLowercase)
            count++;

        Pattern p1 = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p1.matcher(password);
        if(m.find())
            count++;
        Pattern p2 = Pattern.compile("\\d+", Pattern.CASE_INSENSITIVE);
        Matcher m2 = p2.matcher(password);
        if(m2.find())
            count++;

        if(count>=3)
            System.out.println("Valid Password");
        else
            System.out.println("Invalid Password");
    }