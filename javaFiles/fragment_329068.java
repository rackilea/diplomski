for (int i = 0; i < itemsList.size(); i++) {
    if (matching.toLowerCase().contains(itemsList.get(i).toLowerCase())) {
        item = itemsList.get(i).trim();
        break;
    }
}