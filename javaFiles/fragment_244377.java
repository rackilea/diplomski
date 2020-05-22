public Item findBookByISBN(String isbn) {
    for (Item item : listOfItems) {
        if (item.getVolumeInfo().getIndustryIdentifiers().get(0).getIdentifier().equals(isbn)) {
           NameYouWant na = new NameYouWant();
           na.setTitle(item.getTitle());
           na.setPrintType(item.getPrintType());
           na.setPageCount(item.getPageCount());
           na.SetAuthors(item.getAuthors());
           na.SetCategories(item.getCategories());
            return na;
        }
    }
    return null;
}