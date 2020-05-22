public static void main( String[] args ) throws IOException {
    String[] paths = {"/abc/def*/bc", "/abc/def*", "/ab.c/def*", "/ab\\.c/def*", "abc*", "abc/bc"};
    for ( String path : paths ) {
        System.out.println( path + " --> " + path.replaceAll( "((?<=/)|((?<=^)(?=\\w)))(?!(\\w|\\\\\\.)+/.*).*", "" ) );
    }
}