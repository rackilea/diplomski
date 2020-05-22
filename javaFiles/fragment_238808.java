@RunWith(SpringRunner.class)
@WebMvcTest(MyController.class)
@MockBeans({ @MockBean(MySecondService.class), 
             @MockBean(MyThirdService.class) 
           }) // technical mocks for the dependencies resolution

class MyControllerTest { 

    @MockBean
    private MyFirstService s1; 

    @Test
    public void testMethod() [
        // mock s1
        // calls rest controller method
        MvcResult mvcResult = mvc.perform(post("/products")
            .header("Content-Type", "application/json")
            .content(json))
            .andExpect(status().isCreated())
            .andReturn();
    }

}