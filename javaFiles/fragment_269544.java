public int GetTotal() throws FileNotFoundException{
    int total = 0;
    Scanner s = new Scanner(new BufferedReader(new FileReader("Particles/Names.txt")));
    while(s.hasNext()){
            s.next();
            total++;
    }
    return total;
}