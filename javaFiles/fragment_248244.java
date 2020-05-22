void withWilds( List<? extends Map<String,String>> foo ){}
void noWilds( List<Map<String,String>> foo ){}

void main( String[] args ){
    List<HashMap<String,String>> myMap;

    withWilds( myMap ); // Works
    noWilds( myMap ); // Compiler error
}