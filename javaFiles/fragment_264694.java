List<String> names = new ArrayList<>();

System.out.print( "Hello, what is your name? ");
names.add(scanner.next());

if(names.contains( "Frank" )){
    System.out.printf( "Nice to meet you, Frank. My name is John.\n" );
}else{
    System.out.printf( "What an interesting name. My name is John.\n");
}