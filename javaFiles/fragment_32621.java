for (int j = 1; j <= metadata.getColumnCount(); j++) {
        // …
        int currentJ = j;
        Object currentColValue = colValue;
        Object o = jrs2Collection.stream()
          .filter(u -> {
                try { 
                    return (u.getColumnObject(currentJ).equals(currentColValue)); 
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        ) 
        .collect(Collectors.toCollection(TreeSet::new));
    }