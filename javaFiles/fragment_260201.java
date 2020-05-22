private MockMvc mvc;

@Before
public void initialize() {
    mvc = MockMvcBuilders.standaloneSetup(myController).build();
}