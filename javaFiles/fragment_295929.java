Height getById( List<Height> list, Integer id ){
    for( Height h: list ){
        if( h.getId().equals(id) ) return h;
    }
    return null;
}