String source = "0.12,4.56 2,5 0,0.234";

List<Double> a = new ArrayList<Double>();
List<Double> b = new ArrayList<Double>();

Scanner parser = new Scanner( source ).useDelimiter( Pattern.compile("[ ,]") );
while ( parser.hasNext() ) {
    List use = a.size() <= b.size() ? a : b;
    use.add( parser.nextDouble() );
}

System.out.println("A: "+ a);
System.out.println("B: "+ b);