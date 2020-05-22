for( int i = 0; i < in.length(); ++i ){
      if(!used[i] ) {
          out.append( in.charAt(i) );
          used[i] = true;
          permute();
          used[i] = false;
          out.setLength( out.length() - 1 );
      }
}