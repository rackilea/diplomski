rule "Overlap"
when
    $i1 : Instance ($e1 : event == "some event" ) 
    $instances : List( size > 0 ) from collect ( Instance ( event == $e1, this != $i1, 
        this overlappedby $i1 ) )
then
    System.out.println("** Overlap Event for: " + $i1.getName());
    for (int i = 0; i < $instances.size(); i++) {
        System.out.println("Overlaps: " +  ((Instance)$instances.get(i)).getName());
    }
end