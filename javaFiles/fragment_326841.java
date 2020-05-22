ResultSet tableAReusltSet= null;
    ResultSet tableBReusltSet= null;
    ResultSet tableCReusltSet= null;
    List<PseudeContainer> container = new ArrayList<>();
    while (tableAReusltSet.next()) { 
        PseudeConteiner ps = new PseudoContainer();
        ps.col1 = tableAReusltSet.getString("ColumnName");
        container.add(ps);
    }

    int i = 0;
    while (tableBReusltSet.next()) { 
        if(container.size() <= i){
             container.add(new PseudeContainer());
        }
        container.get(i).col2 = tableBReusltSet.getString("ColumnName");
    }

    i = 0;
    while (tableBReusltSet.next()) { 
        if(container.size() <= i){
             container.add(new PseudeContainer());
        }
        container.get(i).col2 = tableBReusltSet.getString("ColumnName");
    }