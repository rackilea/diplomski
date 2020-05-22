String input = "Lorem ipsum dolor sit amet, consectetur adipisicing #{key1}. " +
   "Proin nibh augue, suscipit a, scelerisque #{key1}," + 
   "lacinia in, mi. Cras vel #{key2}. Etiam pellentesque aliquet tellus." + 
   " Phasellus pharetra nulla ac diam. Quisque semper #{key3} at risus.";
StringBuffer result = new StringBuffer();

Pattern p = Pattern.compile( "#\\{([\\w\\.]+)\\}" );
Matcher m = p.matcher( input );

while( m.find() ) {      
  //extract the message for key = m.group( 1 ) here
  //i'll just mark the found keys 
  m.appendReplacement( result,  "##" + m.group( 1 ) + "##" );      
}
m.appendTail( result );

System.out.println(result); //output: ... consectetur adipisicing ##key1## ...  etc.