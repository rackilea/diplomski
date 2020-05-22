package business;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import viewmodels.OrderedProductItem;

public class SUnitTest
{
    ... // Other UnitTests

    @Test
    public void testDoubleSorting(){
        // Arrange
        // Could be with any of them, but we do it with the OrderedProductItems,
        // since they can contain doubles
        ArrayList<OrderedProductItem> opis = new ArrayList<OrderedProductItem>();
        int[] unsortedIds = new int[]{
            12, 12, 54, 54, 12, 4, 4, 4, 7, 76, 45, 44, 1, 2, 34, 5, 4
        };
        // Sorted array of the exact same ID's for comparison
        int[] sortedIds = new int[]{
            1, 2, 4, 4, 4, 4, 5, 7, 12, 12, 12, 34, 44, 45, 54, 54, 76
        };
        for(int i = 0; i < unsortedIds.length; i++)
            // OrderedProductItem uses setProductId in its Constructor
            opis.add(new OrderedProductItem(unsortedIds[i]));

        // Invoke
        Sort.OPI.sortOrderedProductItems(opis);
        ArrayList<OrderedProductItem> resultOpis = Sort.OPI.opisByProductId;

        // Assert
        Assert.assertNotNull("resultOpis should not be null", resultOpis);
        Assert.assertEquals("resultOpis' size should equal the unsortedIds' size", unsortedIds.length, resultOpis.size());
        for(int i = 0; i < sortedIds.length; i++){
            Assert.assertNotNull("The OrderedProductItem at " + String.valueOf(i) + " should not be null", resultOpis.get(i));
            Assert.assertEquals("The OrderedProductItem's ProductId at " + String.valueOf(i) + " should be " + String.valueOf(sortedIds[i]), sortedIds[i], resultOpis.get(i).getProductId());
        }
    }
}