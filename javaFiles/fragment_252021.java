Dto dto = new Dto();
//assumed rs contains the db child results.
for(int i=0; i<rs.length; i++) {
    Child child = new Child(rs.get("sub"), rs.get("amount"))
    dto.getChild().add(child)
}
dto.setName("name");
dto.setTotalAmount(totalAmount);
return dto;