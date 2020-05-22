Scanner scan = new Scanner( System.in );
System.out.println( "use tcp?" );
String in = scan.nextLine();
if( in.indexOf( "y" ) >= 0 || in.indexOf( "Y" ) >= 0 ){
    System.out.println("using tcp");
}else{
    System.out.println("not using tcp, use udp instead?");
}