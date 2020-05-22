@RunWith(Parameterized.class)
public class StaticInjectParamsTest {
    @Rule
    public GuiceBerryRule guiceBerryRule = new GuiceBerryRule(ExtendedTestMod.class)

    @Inject
    private RatingService ratingService

    @Parameter
    public RatingId ratingId;

    @Parameters
    public static Collection<RatingId[]> ratingsParameters() {
    return Arrays.asList(new RatingId[][]{
        {RatingIds.classic()}
        // All the other ratings
        });
    }

    @Test
    public void shouldWork() {
        Rating rating = ratingService.getRatingById(ratingId.getValue())
        //Use the rating in a test

    }
}