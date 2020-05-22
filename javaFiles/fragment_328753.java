while (rs.next()) {

    String airline = rs.getString(1);
    ...
    BigDecimal price = rs.getBigDecimal(8);
    if (price.compareTo(limit) < 0) {
        csvFile.print("LOW!");
    }
    else {
        csvFile.print(price);
    }
}