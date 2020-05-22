public static void main(String[] args)  {
    try (Scanner sc = new Scanner(new File(args[0]))) {
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
    } catch(FileNotFoundException e){
        System.out.println("Het bestand kon niet gevonden worden.");
    } catch(Exception e){
        System.out.println("Onbekende Fout");
    }
}