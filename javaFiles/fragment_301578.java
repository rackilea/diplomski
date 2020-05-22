import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByCategoryTest() throws Exception {
        Book book1 = new Book();
        book1.setActive(true);

        Book book2 = new Book();
        book2.setActive(false);

        when(bookRepository.findByCategory(anyString()))
            .thenReturn(Arrays.asList(book1, book2));

        List<Book> bookList =  bookService.findByCategory("category1");

        verify(bookRepository).findByCategory(anyString());

        assertNotNull(bookList);
        assertEquals(1, bookList.size());
        assertEquals(book1, bookList.get(0));
    }
}