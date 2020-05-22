public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int x = str.length();
        System.out.println(str.substring(0, x/2)); // return part of full string starting from index 0 to mid index
    }