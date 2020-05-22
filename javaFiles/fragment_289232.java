import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FoodTest {

    @Mock
    private FoodRepository foodRepository;

    @InjectMocks
    private FoodService foodService;

    @Captor
    private ArgumentCaptor<Food> foodArgumentCaptor;

    @Test
    public void testFreshestFoods() {

        Food food = new Food();
        food.setFoodName("Meat");
        food.setFresh(true);

        // not needed
        //foodRepository.save(food);
        //verify(foodRepository).save(foodArgumentCaptor.capture());
        //assertThat(foodArgumentCaptor.getValue().getId(), is(notNullValue()));

        when(foodRepository.getMostFreshestFoods()).thenReturn(asList(food));

        List<Food> actual = foodService.getMostFreshestFoods();

        assertEquals(food, actual.get(0));
        verify(foodRepository).getMostFreshestFoods();
    }
}