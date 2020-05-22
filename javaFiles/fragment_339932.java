@RelatedToVia(elementClass=SomeOtherLink.class)  // this is indeed redundant
SomeLink link;

// this is NOT redundant, you lose the type information in runtime in Java
// you only know that link is a set, don't know of which type
@RelatedToVia(elementClass=SomeOtherLink.class)      
Set<SomeLink> link;