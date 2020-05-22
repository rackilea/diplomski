Criteria subCriteria = Criteria.forClass(Table.class);
        subCriteria.setProjection(Projections.distinct(Projections.property("player")));
           
    
        Criteria mainCriteria = createLogRecordCriteria(maxId, playerId, playerStatus, userCategory, from, to);
        mainCriteria.add(Property.forName("t.player").in(subCriteria));
        
    //adding the extra restrictions provided in the Question.
    mainCriteria.setFirstResult(offset);
        mainCriteria.setMaxResults(limit);
    
        List lst = mainCriteria.list(); 
        return lst;