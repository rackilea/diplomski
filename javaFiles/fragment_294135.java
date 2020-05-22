@Autowired
private WebApplicationContext wac;

private MockMvc mockMvc;

@Before
public void setup() {
    DelegatingFilterProxy filterProxy = new DelegatingFilterProxy(
            "springSecurityFilterChain", wac);
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
        addFilter(filterProxy, "/*").build();
}