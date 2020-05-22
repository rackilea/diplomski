select b from Buy b 
left join fetch b.insertionOrders i
where b.buyGroupId = :groupId and b.isDeleted = false

for (Buy b : list) {
    dtoList.add(new BuyDTO(b.getId(), b.getBuyName(), b.getInsertionOrders());
}