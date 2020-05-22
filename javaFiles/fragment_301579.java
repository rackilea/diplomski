import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class BookServiceTest2 {

    private EasyMockSupport support = new EasyMockSupport();

    @TestSubject
    private BookService bookService = new BookService();

    @Mock
    private BookRepository bookRepository;

    @Test
    public void findByCategoryTest() throws Exception {
        Book book1 = new Book();
        book1.setActive(true);

        Book book2 = new Book();
        book2.setActive(false);

        expect(bookRepository.findByCategory(anyString())).andReturn(Arrays.asList(book1, book2));
        replay(bookRepository);

        List<Book> bookList = bookService.findByCategory("category1");

        support.verifyAll();

        assertNotNull(bookList);
        assertEquals(1, bookList.size());
        assertEquals(book1, bookList.get(0));
    }
}