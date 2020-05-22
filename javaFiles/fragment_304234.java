private List<OrderDto> getFilteredList(List<OrderDto> orderDtoList) {

    List<OrderDto> filteredList = new ArrayList<>();
    LocalDateTime now = LocalDateTime.now();

    List<OrderDto> sortedList = orderDtoList.stream().sorted(Comparator.comparing(OrderDto::getDrawDate)).collect(Collectors.toList());

    for (OrderDto dto : sortedList) {
        if (dto.getDrawDate().isAfter(now) && filteredList.stream().noneMatch(orderDto -> Objects.equals(orderDto.getId(), dto.getId()))) {
            filteredList.add(dto);
        }
    }

    Collections.reverse(sortedList);
    for (OrderDto dto : sortedList) {
        if (dto.getDrawDate().isBefore(now) && filteredList.stream().noneMatch(orderDto -> Objects.equals(orderDto.getId(), dto.getId()))) {
            filteredList.add(dto);
        }
    }

    return filteredList;
}