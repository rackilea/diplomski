void importPreviousChildren( @AlsoLoad( "children" ) List<Key> children )
    {
        for( Key key: children )
        {
            ChildEntity c = ofy().load().entity(DatastoreService.get(key))

            if( !childrenNames.contains( c.getName() ) )
                childrenNames.add( c.getName() );
        }
    }