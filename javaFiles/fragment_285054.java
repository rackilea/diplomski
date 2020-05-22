public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = "qwertyuiopasdfghjklzxcvbnm";
        String s2 = "mnbvcxzasdfghjklpoiuytrewq";
        String input, out = "";
        System.out.println("enter input string");
        input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (input.charAt(i) == s2.charAt(j)) {
                     out += s1.charAt((j + 3)%26);
                }
            }

        }
        System.out.println(out);
        sc.close();
    }