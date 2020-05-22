Table<?> t = select()
            .from( TABLE1 )
            .join( TABLE2 ).on( TABLE1.ID.equal( TABLE2.ID ))
            .join( TABLE3 ).on( TABLE1.OTHER_ID.equal( TABLE3.OTHER_ID ))
            .asTable("t");

create.select(t.fields(), count().over())
      .from(t);