public static void main(String[] args){

// CHANGE: just define
Artikel a;

Scanner scanner = new Scanner(System.in);

if (args.length !=8){
    System.out.println("Bitte geben Sie die folgenden Werte, getrennt mit einem ',' ein: Artikelname, Artikelnummer, Mengeneinheit, Packungsgröße, Mindestbestand, Bestellmenge, Lagerbestand, Hersteller");        
    String eingabe = scanner.next();
    String parts[] = eingabe.split(",");
    String string1 = parts[0];
    String string2 = parts[1];
    String string3 = parts[2];
    int int1 = Integer.parseInt(parts[3]);
    int int2 = Integer.parseInt(parts[4]);
    int int3 = Integer.parseInt(parts[5]);
    int int4 = Integer.parseInt(parts[6]);
    String string4 = parts[7];

    // CHANGE: instantiate here
    a = new Artikel(string1, string2, string3, int1, int2, int3, int4, string4);
}
else{
    // CHANGE: instantiate here
    a = new Artikel(args[0], args[1], args[2], Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]), args[7]);
}