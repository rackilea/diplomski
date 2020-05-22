import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

[..]

@Mock
EntityManager manager;

@Mock
TypedQuery<Movie> query;

[..]

@Before
public void setUp() {
    final Movie first = new Movie();
    first.setName("MISSION IMPOSSIBLE");
    first.setAvailableCopies(10);
    first.setIsbn("ABC788900");

    final Movie second = new Movie();
    first.setName("JAMES BOND");
    first.setAvailableCopies(10);
    first.setIsbn("ABC788999");

    final Movie last = new Movie();
    first.setName("HARRY POTTER");
    first.setAvailableCopies(10);
    first.setIsbn("ABC7882000");

    when(manager.createQuery(any(String.class), eq(Movie.class))).thenReturn(query);
    when(query.setParameter(any(String.class), any(String.class))).thenReturn(query);
    when(query.getSingleResult()).thenReturn(first, second, last);
}