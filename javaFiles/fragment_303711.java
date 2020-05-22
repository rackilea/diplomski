for (int y = 0; y < products.size(); y++) {
        if (selloutput.equalsIgnoreCase(products.get(y).getName())) {
            sellthis += 1;
            candidates.add(products.get(y));
            break;
        }else if(products.get(y).getName().toUpperCase().contains(selloutput.toUpperCase())){
            sellthis += 1;
            candidates.add(products.get(y));
        }
    }