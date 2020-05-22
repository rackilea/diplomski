public static void main(String[] args) {
        ArrayList<String []> a = new ArrayList<>();
        String b[] = {"not here","not here2"};
        String c[] = {"not here3","i'm here"};
        a.add(b);
        a.add(c);
        for (String[] array : a) {// This loop is used to iterate through the arraylist
            for (String element : array) {//This loop is used to iterate through the array inside the arraylist
                if(element.equalsIgnoreCase("i'm here")){
                    System.out.println("found");
                    return;
                }
            }
        }
        System.out.println("match not found");
}