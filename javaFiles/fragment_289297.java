rule "test Second true"
when
    $o1 : MyObject( isNew == null ) // isNew is a Boolean()
    $o2 : MySecondObject( name = "ABC" )
then
    modify($o1) { setNew(true) };
    modify($o2) { setName("DEF") };
end

rule "test Second missing"
when
    $o1 : MyObject( isNew == null ) // isNew is a Boolean()
    not MySecondObject( name = "ABC" )
then
    modify($o1) { setNew(false) }; //init to false
end