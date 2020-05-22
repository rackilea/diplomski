Map<String, Command> PROTOCOL = ... //you build that map somehow

Command c = PROTOCOL.get(handle);
if( c != null ) {
    System.out.println("good");
    c.execute();
} else { 
    throw new Exception("Don't understand <" + handle + ">");
}