List<Object[]>resultList= (List<Object[]>)session.createCriteria(TableA.class, "aliasOfTableA") 
                .add(Restrictions.eq("aliasOfTableA.columnAA", "AAA"))  
                .createCriteria("aliasOfTableA.tableBId" , "aliasOfTableB")
                .add(Restrictions.eq("aliasOfTableB.columnBB", "BBB"))
                .createCriteria("aliasOfTableA.tableCId" , "aliasOfTableC")
                .add(Restrictions.eq("aliasOfTableC.columnCC", "CCC"))
                .setProjection( Projections.projectionList()
                        .add( Projections.property("aliasOfTableA.columnA") )
                        .add( Projections.property("aliasOfTableB.columnB"))
                        .add( Projections.property("aliasOfTableC.columnC") )
                ).list();

for (Object[] obj : resultList) {
        System.out.println(obj[0]); //print the value from TableA.columnA
        System.out.println(obj[1]); //print the value from TableB.columnB
        System.out.println(obj[2]); //print the value from TableC.columnC
}