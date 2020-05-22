public static void main(String[] args) {
    char w;
    System.out.println("donner une chaine");
    Scanner sc =  new Scanner(System.in);
    String name = sc.nextLine();
    System.out.println("donner un caractere");
    w = sc.next().charAt(0);
    int val = search(name, w);
    System.out.println("la position de la lettre " + w + " est "+ val);
    name = name.replace(name.charAt(val)+"", ""); //replace old character (notice conversion to String) with empty String.
    sc.close();
    System.out.println(name);
}