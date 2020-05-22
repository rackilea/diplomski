interface MediaType {}

enum BookTypes implements MediaType {
    HARDCOVER;
}

enum MagazineTypes implements MediaType {
    MONTHLY;
}

Map<MediaType, MediaItem> itemMap = new HashMap<MediaType, MediaItem>();
itemMap.put(BookTypes.HARDCOVER, new Book());
itemMap.put(MagazineTypes.MONTHLY, new Magazine());