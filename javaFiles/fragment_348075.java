public List<Jam> getCurrent(){
        Cursor cursor = r.table("jam")
                .filter(row -> row.hasFields("endedAt").not())
                .run(conn);
        List<Map<String,Object>> list=cursor.toList();
        return list.stream().map(item->JamRepository.toJam(item)).collect(Collectors.toList());
}