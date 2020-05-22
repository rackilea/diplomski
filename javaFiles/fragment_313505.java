public static void main(String[] args)  {
    Scanner sc = null;
    try {
        sc = new Scanner(new File(args[0]));
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
    } catch(FileNotFoundException e){
        System.out.println("Het bestand kon niet gevonden worden.");
    } catch(Exception e){
        System.out.println("Onbekende Fout");
    }
    finally {
        if (sc != null) {
            try {
                sc.close();
            }
            catch (Exception) {
            }
        }
    }
}