rule  "a person's interests b"
when
    $ip: InteresesPersonaId( $p: persona, $i: interes)
    Person( this == $p, $id: id ) 
    Interes( this == $i, $nom: nombre )
then
    System.out.println( $id + " likes " + $nom );
end