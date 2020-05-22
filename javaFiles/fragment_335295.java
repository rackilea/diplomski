import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceImplTest {

  @InjectMocks
  CityService cityService;

  @Mock
  CityDao cityDao;

  private City city = new City();

  @Before
  public void init() {
    city.setId(1L);
    city.setPinCode("1234");
    city.setCityName("Mumbai");
  }

  @Test
  public void findById() {
    when(cityDao.findById(1L)).thenReturn(Optional.of(city));
    cityService.findById(1L);
  }
}