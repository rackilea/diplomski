@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PizzaValidatorTest {

  private Pizza meatPizza;

  @Autowire
  private PizzaValidator validator;

  @MockBean
  private IngredientRepository ingredientRepository;

  @MockBean
  private PizzaSizeRepository pizzaSizeRepository;

  @Before
  public void setUp() throws Exception {

    meatPizza = new Pizza();

    }

  @Test
  public void validateValid() {
        when(ingredientRepository.existsById(any())).thenReturn(true);
        when(pizzaSizeRepository.existsById(any())).thenReturn(true);
        assertTrue(validator.validate(meatPizza));
     }
 }