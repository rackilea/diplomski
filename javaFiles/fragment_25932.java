public static List<String> getTitles(){
    Scanner numberOfTitles = new Scanner(System.in);
    System.out.println("Enter number of titles: ");
    int titlesAmount = numberOfTitles.nextInt();
    int count = 1;

    List <String> titles = new ArrayList<String>();

    while (count <= titlesAmount){
        Scanner titlesReader = new Scanner(System.in);
        System.out.println("Enter title: ");
        String titlesInput = titlesReader.next();
        titles.add(titlesInput);
        count++;
    }
    return titles;
}