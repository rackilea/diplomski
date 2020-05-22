@ContextConfiguration("ProjectFacadeTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminSpringControllerTests {
...
private MockMvc mockMvc;
...
@Before
public void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(imageController).build();
}

EasyMock.expect(mockPersistedProjectService.getImages(EasyMock.anyLong())).andReturn(images);
EasyMock.replay(mockPersistedProjectService);
    MvcResult result =
            this.mockMvc.perform(get("/resources/projects/1000/images")).andExpect(content().type("application/json"))
                    .andExpect(status().isOk()).andReturn();
MockHttpServletResponse response = result.getResponse();
//VERIFY RESPONSE
EasyMock.verify(mockPersistedProjectService);