public List<Map<TypeId, Object> > merge(List<Map<TypeId, Object> > col1, List<Entity> col2){
    col1.forEach(map -> map.put(TypeId.AMOUNT, 
        col2.stream()
            .filter(e -> e.player_id == (int)map.get(TypeId.PLAYER) && 
                         e.platform_id == (int)map.get(TypeId.PLATFORM))
            .findFirst().map(e -> e.amount).orElse(null)
        ));
    return col1;
}