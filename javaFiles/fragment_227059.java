public static void main(String[] args) {
    Collection c = new Collection();

    c.Add( new Album("DaftPunk","Discovery","2001"));
    c.Add( new Album ("Pink Floid","The Dark Side Of The Moon","1973"));
    c.Add( new Album( "The Clash", "London Calling", "1979"));
    c.sort();
    System.out.print(c);  
}