String str = "1 20 25 [1 2 3] [4 5]";

Scanner scan = new Scanner(str);
int intVariable = 0;
ArrayList<Integer> listVariable = null; //null marks no active list

while (scan.hasNext()) { //try/catch here is highly recommeneded!

    //read next input (separated by whitespace)
    String next = scan.next();

    if (next.startsWith("[")) {
        //init new list and store first value into it
        listVariable = new ArrayList<Integer>();
        listVariable.add(Integer.parseInt(next.substring(1)));
    } else if (next.endsWith("]")) {
        //add the last item to the list
        listVariable.add(Integer.parseInt(next.substring(0, next.length()-1)));
        System.out.println(Arrays.toString(listVariable.toArray()));
        //reset the list to null
        listVariable = null;
    } else {
        //if inside a list, add it to list, otherwise it is simply an integer
        if (listVariable != null) {
            listVariable.add(Integer.parseInt(next));
        } else {
            intVariable = Integer.parseInt(next);
            System.out.println(intVariable);
        }
    }
}