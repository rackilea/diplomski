try {
    shiFilter.reset();
    while( shiFilter.incrementToken() ) {
        token = cta.toString();
        System.out.println( token );
    }
    shiFilter.end();
    shiFilter.close();
} 
catch ( IOException ioe ) {
    ioe.printStackTrace();
}