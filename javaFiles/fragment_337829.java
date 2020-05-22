rule "a person's interests a"
when
    Person( $id: id, $pip: interesesP ) 
    $ip: InteresesPersona() from $pip
    Interes( interesesP contains $ip, $nom: nombre )
then
    System.out.println( $id + " likes " + $nom );
end