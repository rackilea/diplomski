rule "collect names"
when
    accumulate( TestData( $n: name ); $names: collectList( $n ) )
then
    // ... $names is a List containing String objects
end