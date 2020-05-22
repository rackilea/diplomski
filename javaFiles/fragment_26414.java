List<?> tmp = query.getResultList();
    List<Map<String, Object>> segments = new ArrayList<Map<String, Object>>();
    for(Object t : tmp)
    {
        Object[] tt = (Object[]) t;
        Map<String, Object> rMap = new HashMap<String, Object>();
        rMap.put("name", tt[0]);
        rMap.put("version", tt[1]);
        rMap.put("ct", tt[2]);
        segments.add(rMap);
    }