rule "IsJohn"
dialect "mvel"
when
    fact0: Patient( name == "John")
then        
    fact0.setResultString( "Pass" );
    fact0.setName( "Patient: John" );
    update( fact0 );   
    // Only do the 'update' if you want other rules to be aware of this change. 
    // Even better, if you want other rules to notice these changes use 'modify' 
    // construct insted of 'update'. From the java perspective, you don't need 
    // to do this step: you are already invoking setResultString() and setName()
    // on the real java object.
end