Object obj1 = amountSpnr.getValue();
    Object obj2 = productData[3];

    if (obj1 instanceof Integer) {
        int amount = (Integer) obj1; // 1
    }

    if (obj2 instanceof Float) {
        float total = (Float) obj2; // 2
        total *= amount;
    }