class RecipeCompare implements Comparator<Recipe> {

    @Override
    public int compare(Recipe o1, Recipe o2) {
        // write comparison logic here like below , it's just a sample
        return o1.getID().compareTo(o2.getID());
    }
}