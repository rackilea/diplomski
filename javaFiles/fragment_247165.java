import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import biz.cogitare.framework.controllers.advices.ExceptionControllerAdvice;

@RunWith(MockitoJUnitRunner.class)
public class RestControllerTest {

    private MockMvc mockMvc;

    private Item item;

    private String itemJSON;

    @Mock
    private Manager manager;

    @InjectMocks
    private RestController restController = new RestController();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(restController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter());

         Item item = myTestItemPreInitiallized;

        itemJSON = new ObjectMapper().writeValueAsString(itm);
    }

    @Test
    public void testQuerySuccess() throws Exception {

        List<Item> items = new ArrayList<>();
        items.add(item);

        Mockito.when(manager.findItems()).thenReturn(items);

        mockMvc.perform(get("/items?itemId=1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
                //.andExpect(jsonPath("$[0].id", is(1)))
                //.andExpect(jsonPath("$[0].name", is("xyz")));

        Mockito.verify(manager).findItems();
    }


    @Test
    public void testInsertSuccess() throws Exception {

        Mockito.when(manager.insertOrUpdate(Mockito.any(Item.class))).thenReturn(item);

        mockMvc.perform(post("/items").contentType(MediaType.APPLICATION_JSON).content(itemJSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());

        Mockito.verify(manager).save(Mockito.any(Item.class));
    }
}