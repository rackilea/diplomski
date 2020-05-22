for(ContactDto dto : l) {
  totalValue += dto.getValue();
}

for(ContactDto dto : l) {
  dto.setTotalValue(totalValue);
}