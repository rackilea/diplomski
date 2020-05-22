rule "listRule"
when
    $list: ArrayList()
    $s1: String( toString != "a" && != "b" ) from $list
    $s2: String( this != $s1, toString !="c" && != "z" ) from $list
then
    System.out.println( "Strings: " + $s1 + " - " + $s2 );
end