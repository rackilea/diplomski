create().select(MY_TABLE.ID)
        .from(MY_TABLE)
        .whereExists(
            selectOne()
            .from(unnest(MY_TABLE.TYPES).as("types", 
                 MY_TYPE.ID.getName(), 
                 MY_TYPE.SOMETHING.getName()
             ))
            .join(TYPE_TABLE)
            .on(TYPE_TABLE.ID.eq(field(name("types", MY_TYPE.ID.getName()), 
                                     MY_TYPE.ID.getDataType())))
        )
        .fetch(MY_TABLE.ID);