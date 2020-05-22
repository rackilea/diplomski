public static void main(String[] args) {
    Metadata meta = new Metadata();
    int length = args.length;
    for ( int i = 0; i < length; i++ ) {
        if (new File(args[i]).exists()) {
            meta.readAndDisplayMetadata( args[i] );
        } else {
            System.out.println("cannot find file: " + args[i]);
        }
    }
}