StringBuffer sb = new StringBuffer( "\\b(" );
 String del = "";
 for( String t: tokens ){
     sb.append( del ).append( t );
     del = "|";
 }
 pattern = sb.toString();