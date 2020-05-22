JAXBElement<IdType> jbe =
        (JAXBElement<IdType>)u.unmarshal( new File( "mixed.xml" ) );
for( Object obj: jbe.getValue().getContent() ){
    System.out.println( obj.getClass() + " " + obj );
    if( obj instanceof String ){
        // text child (even the blank space
    } else if( obj instanceof JAXBElement ){
        // process an element child wrapped into JAXBElement
    }
}