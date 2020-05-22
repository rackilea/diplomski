public static void main(String[] args)
    {
        String inputString;
        System.out.println("Please Enter the String");
        Scanner sc = new Scanner(System.in);
        inputString = sc.nextLine();
        sc.close();
        int len=inputString.length();
        char[] name = new char[len];
        for(int i =0; i < len; i++)
        {
            name[i] = inputString.toUpperCase().charAt(i);
        }
        System.out.println(name);
    }