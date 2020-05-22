package basic;

    import static basic.SubCatMain.RedSubCategory.*;
    import static basic.SubCatMain.BlueSubCategory.*;

    public class SubCatMain {

        public interface Category {
        }

        public enum MainCategory implements Category {
            RED(MAROON, ORANGE, BORDEAUX), 
            BLUE(LIGHT, DARK, AZURE);

            final private Category[] subcategories;

            private MainCategory(Category... subcategories) {
                this.subcategories = subcategories;
            }

            public Category[] getSubcategories() {
                return subcategories;
            }
        }

        public enum RedSubCategory implements Category {
            MAROON, ORANGE, BORDEAUX;
        }

        public enum BlueSubCategory implements Category {
            LIGHT, DARK, AZURE;
        }

        public static void main(String[] args) {
            // do something with your categories
        }

    }