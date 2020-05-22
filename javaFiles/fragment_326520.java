rule "brief CURRENT"
when
  Person( $name: name, $pa: personAddress )
  PersonAddress( type == AddressType.CURRENT, timeAtAddress < 3 ) from $pa
then
end
rule "no PREVIOUS"
extends "brief CURRENT"
when
  not PersonAddress( type == AddressType.PREVIOUS ) from $pa
then
  System.out.println( "invalid. " + $name );
end
rule "has PREVIOUS"
extends "brief CURRENT"
when
  $ppa: PersonAddress( type == AddressType.PREVIOUS ) from $pa
then
  System.out.println( "valid. " + $name +
                      " at " + $ppa.getAddress().getCity() );
end