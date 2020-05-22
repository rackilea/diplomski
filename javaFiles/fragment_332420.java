...
buffer.append("charset=UTF-8\n");
buffer.append("item_name="     + reservedPackage.getName() + "\n");
buffer.append("item_number="   + reservedPackage.getId() + "\n");
buffer.append("amount="        + (reservedPackage.getPrice() - reservedPackage.getDiscount()) + "\n");
buffer.append("currency_code=SGD" + "\n");
...