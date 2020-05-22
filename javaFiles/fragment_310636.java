Predicate inactiveCompaniesPredicate = new Predicate() {
            @Override
            public boolean apply(PredicateContext ctx) {
                if(ctx.item(Map.class).containsKey("errorMsg") && 
                    ((JSONArray)((JSONArray) ctx.item(Map.class).get("errorMsg")).get(0)).get(0).equals("INACTIVE")) {
                    return true; 
                } else {
                    return false; 
                }
            }
        };