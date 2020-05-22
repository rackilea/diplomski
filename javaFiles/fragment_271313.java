public static void main(String[] args){
    String pattern = "(\\S+(?<!,)\\s+(\\d+\\s+)*)";
    Scanner sc = new Scanner(System.in);
    while(true){
        String theString = sc.nextLine();

        String[] keywords = theString.replaceAll(pattern+".*","$1").split(" ");
        String[] ids = theString.split(pattern)[1].split(",\\s?");

        System.out.println("Keywords:");
        for(String keyword: keywords){
            System.out.println("\t"+keyword);
        }
        System.out.println("IDs:");
        for(String id: ids){
            System.out.println("\t"+id);
        }
        System.out.println();
    }
}