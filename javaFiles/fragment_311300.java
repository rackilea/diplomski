rule "countVN"
when
  $vn: ArrayList( $s: size )
  accumulate( String( toString == "V" ) from $vn;
              $cnt: count( 1 );
              $cnt.doubleValue()/$s >= 0.8 )
then
  System.out.println( "80% or more" );
end