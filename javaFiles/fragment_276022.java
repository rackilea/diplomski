String[] names = new String[]{"jack", "jackson", "jason", "dijafu"};
long start = 0;
long stop = 0;

//Contains
start = System.nanoTime();
for (int i = 0; i < names.length; i++){
    names[i].contains("ja");
}
stop = System.nanoTime();
System.out.println("Contains: " + (stop-start));

//IndexOf
start = System.nanoTime();
for (int i = 0; i < names.length; i++){
    names[i].indexOf("ja");
}
stop = System.nanoTime();
System.out.println("IndexOf: " + (stop-start));

//Matches
start = System.nanoTime();
for (int i = 0; i < names.length; i++){
    names[i].matches("ja");
}
stop = System.nanoTime();
System.out.println("Matches: " + (stop-start));