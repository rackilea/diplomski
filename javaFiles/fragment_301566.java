package misc.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnitTestWithCategory {

    @Category({CategoryA.class, CategoryB.class})
    @Test
    public final void Test() {
        System.out.println("In Test 1");
    }

    @Category(CategoryA.class)
    @Test
    public final void Test2() {
        System.out.println("In Test 2");
    }

}