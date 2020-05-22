private String nameTransform(OrderDTO orderDTO) {
    String name = orderDTO.getName();
    String newName;
    int length = name.length();

    if (length < 1) {
        newName = "0000" + name;
    }
    if (length < 2) {
        newName = "000" + name;;
    }
    if (length < 3) {
        newName = "00" + name;
    }
    if (length < 4) {
        newName = "0" + name;
    } else {
        return name;
    }
    orderDTO.setName(newName);
    return nameTransform(orderDTO);
}