while( values.get(0).hasNext() ){
   for(int i = 0; i < values.size(); i++){
      out.print( values.get(i).next() + "\t" );
   }
   out.println();
}