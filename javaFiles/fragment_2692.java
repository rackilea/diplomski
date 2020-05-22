public class Libreria {
public static void main(String[]arg){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String nome="", cognome="", periodo="", titolo="", nomenew="", cognomenew="", editore="";
    int annoLibro=0, giorno, mese, anno;
    Calendar data=Calendar.getInstance();
    ArrayList<Libro> libri = new ArrayList<Libro>(); 
    Editore e= new Editore();

    System.out.print("Inserisci il nome dell' editore: ");
        try{
            editore=br.readLine();
        }catch(Exception ex){
            System.err.println("ERRORE");
        }

        for(int j=0; j<2; j++){

        Autore a= new Autore();
        Libro l = new Libro();

        System.out.print("Inserisci il titolo del libro: ");
        try{
            titolo= br.readLine();
        }catch(Exception ex){
            System.err.println("ERRORE");
        }

        System.out.print("Inserisci l' anno del libro: ");
        try{
            annoLibro= Integer.valueOf(br.readLine());
        }catch(Exception ex){
            System.err.println("ERRORE");
        }

        System.out.print("Inserisci il nome dell' autore: ");
        try{
            nome= br.readLine();
        }catch(Exception ex){
            System.err.println("ERRORE");
        }

        System.out.print("Inserisci il cognome dell' autore: ");
        try{
            cognome= br.readLine();
        }catch(Exception ex){
            System.err.println("ERRORE");
        }
        a.setCognome(cognome);
        System.out.print("Inserisci il periodo dell' autore: ");
        try{
            periodo= br.readLine();
        }catch(Exception ex){
            System.err.println("ERRORE");
        }
        a.setPeriodo(periodo);
        try{
            System.out.print("Inserisci il giorno di nascita dell' autore: ");
            giorno= Integer.valueOf(br.readLine());
            System.out.print("Inserisci il mese di nascita dell' autore: ");
            mese= Integer.valueOf(br.readLine());
            System.out.print("Inserisci l' anno di nascita dell' autore: ");
            anno= Integer.valueOf(br.readLine());
            data.set(anno, mese, giorno);

        }catch(Exception ex){
            System.err.println("ERRORE");
        }

        a = new Autore(nome, cognome, periodo, data);
        l = new Libro(titolo, a, annoLibro);
        libri.add(l);

        System.out.println("Autore is " + a.getNome());
        System.out.println("Libro is " + l.getTitolo());

        System.out.println("AUTORE SUCCESSIVO");     
    }

    e= new Editore(editore, libri);
    System.out.println("Editore is " + e.getNome());


    System.out.println("Di quale autore vuoi stampare i libri? (nome then cognome)");
    Autore b = new Autore();
    try{
        nomenew=br.readLine();
        cognomenew=br.readLine();
        }catch(Exception ex){
            System.err.println("ERRORE");
        }
    b.setNome(nomenew);
    b.setCognome(cognomenew);
    ArrayList<Libro> finalList = e.getLibriByAutore(libri, nomenew, cognomenew);

    if(!finalList.isEmpty()) {
        for(Libro libro : finalList) {
            System.out.println("Libri : " + libro.getTitolo());
        }

    } else {
        System.out.println("Not found!");
    }



}
}