public class Category{

    // STATE
    private String mCategoryName;
    private Boolean mContainsSubcategories;
    private Subcategory[] mSubcategoryList; // Subcategory is another object
    // Constructor
    public static Category getInstance(boolean mContainsSubcategories,String mCategoryName, Subcategory[] subcategoryList) {
        if (mContainsSubcategories){
            return new Category(mCategoryName);
        }else {
            return new Category(mCategoryName,subcategoryList);
        }
    }
    // for mContainsSubcategories == false, use the below constructor
    public Category(String categoryName){

    }
    // for mContainsSubcategories == true, use the below constructor
    public Category(String categoryName, Subcategory[] subcategoryList){

    }

    // GETTER METHODS
    /* ..................... */
}