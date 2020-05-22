Object primaryKey = evento.getPrimaryKey();
Object tmpEvento = PUEntityManager.load( Evento.class, primaryKey )

if ( tmpEvento == null )
{
    tmpEvento = PUEntityManager.persist( evento );
}
else
{
    // If the evento already exists, you need to decide which attributes of
    // the evento in the DB that you want to copy over to the evento
    // you want to merge.  This is only an example.
    tmpEvento.setXXX( evento.getXXX() );
    tmpEvento.setYYY( evento.getYYY() );
    tmpEvento = PUEntityManager.merge( tmpEvento );
}

// I recommend returning the tmpEvento object after persisting or merging.
return tmpEvento;