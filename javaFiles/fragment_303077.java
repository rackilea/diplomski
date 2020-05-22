rule findInt
when
    Integer( $iv: intValue > 42 )
then
    System.out.println( "got an Integer > 42: " + $iv );
end