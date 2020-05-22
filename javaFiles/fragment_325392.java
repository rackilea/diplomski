public static void main(String[] args) {
    String[] str={"I am Alive.","Are you dead?","Let's see if it works."};
    String search;

    Scanner s=new Scanner(System.in);
    System.out.println("Enter word");
    search=s.nextLine();

    boolean found = false;
    for(int i=0;i<str.length;i++){
        if(str[i].contains(search)){
            System.out.println(str[i]);
            found = true;
        }
    }

    if (!found) {
        System.out.println("Not found");
    }
}