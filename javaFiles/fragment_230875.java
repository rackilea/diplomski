@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTests {

   @Autowired
   private MovieRepository myRepository;

   @Test
   public void findRelatedMoviesToMovieByIdTest() {
       ...
       Page<Movie> movies= myRepository.findRelatedMoviesToMovieByIdTest(1, new PageRequest(1, 10));
       ...
   }
}