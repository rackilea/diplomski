query = monthQb
        .range()
            .onField( "startTS" ).ignoreFieldBridge()
            .from( DateTools.dateToString( from, DateTools.Resolution.MILLISECOND ) )
            .to( DateTools.dateToString( to, DateTools.Resolution.MILLISECOND ) ).excludeLimit()
            .createQuery();