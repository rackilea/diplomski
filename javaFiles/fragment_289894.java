rule "create pedometer"
when
    Steps( $s: steps )
    not Pedometer()
then
    insert( new Pedometer( $s ) );
end

rule "update pedometer"
no-loop
when
    Steps( $s: steps )
    $p: Pedometer( $r: readout )
then
    modify( $p ){
        setReadout( $r + $s )
    }
end