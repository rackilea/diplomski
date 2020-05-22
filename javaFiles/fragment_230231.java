String[] images = {"ferrari", "alpina", "porsche", "volkswagen", .......};
Map<String, Integer> brandImagesMap = new HashMap<String, Integer>();

for(String imageName : images) {
    int drawableResourceId = this.getResources().getIdentifier(imageName, "drawable", this.getPackageName());
    brandImagesMap.put(imageName, drawableResourceId);
}