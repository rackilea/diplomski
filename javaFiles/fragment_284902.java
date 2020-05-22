addChild( Parent detachedParent )
{
   Child child = new Child( );
   child.setID( 0 );
   child.setParent( detachedParent );

   detachedParent.getChildList().add( child );

   parent = em.merge( detachedParent ); // assign merged copy to parent
   em.flush();

   parent.getID(); // will display ID in db
   parent.getChildList( 0 ).getID(); // will have ID from database
   parent.getChildList( 1 ).getID(); // should display same id as the one from DB
}