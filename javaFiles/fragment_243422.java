public static void main(String[] args){
     Scanner kb = new Scanner(System.in);
     String[] temp;
     int i, j;

     while (kb.hasNextLine()) {
        String input = kb.nextLine();
        if (input.equals("")) break;
        temp = input.split(" ");
        i = Integer.parseInt(temp[0]);
        j = Integer.parseInt(temp[1]);
        solve(i, j);
     }
}