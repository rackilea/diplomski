public static void read() throws IOException {
    System.out.println("Etape1");
    File indexDirectory = new File("D:/index/DEV_IdxDOSSIER/data/index");
    IndexReader r = IndexReader.open(FSDirectory.open(indexDirectory));
    System.out.println("Etape2");
    int num = r.numDocs();
    int nbrUA = 0 ;
    for (int i = 0; i < num; i++) {
        Document d = r.document(i);
        System.out.println("DC_KEY: " + d.get("DC_KEY"));
        try {
            FileWriter fw = new FileWriter("D:\\index\\test.txt", true);
            BufferedWriter output = new BufferedWriter(fw);
            if (d.get("DC_KEY") != null) {
                output.write(d.get("DC_KEY") + "\r\n");
                System.out.println("fichier mis à jour");
            } else {
                System.out.println("Le DC_KEY est null c'est une Unité d'Archive");
                nbrUA++;
            }
            output.flush();
            output.close();

        } catch (IOException ioe) {
            System.out.println("the fonction write didn't Work, here is the Error");
            ioe.printStackTrace();
        } catch (NullPointerException ioe) {
            System.out.println("Erreur : pointeur null");
            System.out.println("the fonction write didn't Work, here is the Error");
            ioe.printStackTrace();
        }
        System.out.println("nombre de document traité : " + (i + 1) + "\r\n");
    }
    r.close();
    System.out.println("nombre d'Unité d'Archive : " + nbrUA + "\r\n");
}