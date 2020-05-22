for(Map.Entry<Integer, NationalityDto> m1 : sortedMap.entrySet()) {
    list.add(m1.getValue());
}

Collections.sort(list, (e1, e2) -> e1.getDesc().compareTo(e2.getDesc()));

Map<Integer, NationalityDto> map = new LinkedHashMap<>();

for(NationalityDto dto : list){
    map.put(dto.getNatid(), dto);