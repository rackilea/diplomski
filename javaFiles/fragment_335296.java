import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CityServiceImplTest {

  @InjectMocks
  CityService cityService;

  @Mock
  CityDao cityDao;

  private City city = new City();

  @BeforeEach
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