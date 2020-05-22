boolean foundIt = false;
    for (InventoryRow ir : videos) {
        if (line3.equals(ir.getName())) {
            foundIt = true;
            break;
        }
    }
    if (foundIt) {
        System.out.println("Video found!");