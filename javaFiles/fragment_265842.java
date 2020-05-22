rule "customer in department"
when
    CustomerObj( $cid: custId, $p: point )
    Department( $did: departmentId, $dloc: deptLocation,
                $dloc.contains( $p ) )
then
    System.out.println( "customer " + $cid + " in " + $did );
end