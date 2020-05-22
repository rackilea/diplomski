public static Item findItemType(String symbol) {
        for(Item i : Item.values()) {
            if(String.valueOf(i.getSymbol()).equals(symbol)) {
                return i;
            }
        }
        return null;
    }