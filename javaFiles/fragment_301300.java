rule "new id"
when
    $ae: AlertEvent( $id: sysId )
    not Monitor( sysId == $id )
then
    retract( $ae );
    insert( new Monitor( $id, new Date() ) );
end

rule "same id, within interval, second"
when
    $ae: AlertEvent( $id: sysId, $ts: timestamp )
    $m: Monitor( sysId == $id, count == 1,
                 eval( $m.inInterval( $ts ) ) )
then
    retract( $ae );
    modify( $m ){ incCount() }
    System.out.println( "alarm for " + $id );
end

// This rule is redundant - just in case.
rule "same id, within interval, third or more"
when
    $ae: AlertEvent( $id: sysId, $ts: timestamp )
    $m:  Monitor( sysId == $id, count > 1,
                  eval( $m.inInterval( $ts ) ) )
then
    retract( $ae );
    modify( $m ){ incCount() }
end

rule "same id, not within interval"
when
    $ae: AlertEvent( $id: sysId, $ts: timestamp )
    $m: Monitor( sysId == $id,
                 eval( ! $m.inInterval( $ts ) ) )
then
    retract( $ae );
    modify( $m ){ reset( new Date() ) }
end