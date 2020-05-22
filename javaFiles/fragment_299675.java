function isAnagram( s1, s2 ) {
    return(
        s1.length === s2.length  &&
        sortString(s1) === sortString(s2)
    );
}

function sortString( s ) {
    return s.split('').sort().join('');
}

function test( s1, s2, expected ) {
    var result = isAnagram( s1, s2 );
    var ok = ( result === expected ? 'OK' : '*FAIL*' );
    console.log( s1, s2, result, ok );
}

test( 'dog', 'cat', false );
test( 'bag', 'big', false );
test( 'bag', 'gab', true );
test( 'bags', 'gab', false );
test( 'foobar', 'baroof', true );
test( 'aaaa', 'abbb', false );