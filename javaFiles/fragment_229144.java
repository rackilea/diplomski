Collections.sort( people, new Comparator<Map<String, Object>>() {
    @Override
    public int compare( Map<String, Object> o1, Map<String, Object> o2 ) {
        return (Integer.parseInt((String)o1.get( "type" ))) - 
                (Integer.parseInt((String)o2.get( "type" )));
    }
} );