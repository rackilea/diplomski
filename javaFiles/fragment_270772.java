//build your generic select
        Select select = QueryBuilder.select().all().from("test");

        List<Clause> whereClauses = new ArrayList<>();

        /*
         * Generate Clauses based on a value not being null. Be careful to
         * add the clustering columns in the proper order first, then any index
         */
        if(col1 != null) {
            whereClauses.add(QueryBuilder.eq("col1Name", "col1Val"));
        }

        if(col2 != null) {
            whereClauses.add(QueryBuilder.eq("col2Name", "col2Val"));
        }

        // Add the Clauses and execute or execute the basic select if there's no clauses
        if(!whereClauses.isEmpty()) {
            Select.Where selectWhere = select.where()
            for(Clause clause : whereClauses) {
                selectWhere.and(clause);
            }
            session.execute(selectWhere)
        } else {
            session.execute(select)
        }