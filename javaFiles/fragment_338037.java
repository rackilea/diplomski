public String getCategory(CategoryType category) {
    assert (category != null);

    switch (category) {
        case CategoryType.CRIME:
            return getCrime();
        case CategoryType.BESTSELLER:
            return getBestSellers();
        case CategoryType.BIOGRAPHY:
            return getBiographies();
        case CategoryType.FANTASY:
            return getFantasy();
        case CategoryType.GUIDES:
            return getGuides();
        case CategoryType.MOST_PRECISE_BOOK:
            return getMostPreciseBook();
        case CategoryType.ROMANCES:
            return getRomances();
        default:
            throw new IllegalArgumentException("Unexpected category: " + category)
    }
}