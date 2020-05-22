Category laCat = new Category();
laCat.setId(categoryId);
laCat.getAds().add(ad);
// Next line will insert on CATEGORY and CATEGORY_AD tables
laCat = categoryRepository.saveAndFlush(category);

// We add the category to the ad object to keep both sides in sync
ad.getCategories().add(laCat);