public static void main(String args[]) {

    String str = "hello bonjour \"good morning\" buongiorno";
    System.out.println(str);
    String[] parts = str.split("\"");
    List<String> myList = new ArrayList<String>();
    int i = 1;
    for(String partStr : parts) {
        if(i%2 == 0){
            myList.add(partStr);
        }
        else {
            myList.addAll(Arrays.asList(partStr.trim().split(" ")));
        }
        i++;
    }

    System.out.println("MyList : " + myList);


}