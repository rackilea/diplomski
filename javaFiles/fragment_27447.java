protected MockMvc mockMvc;

@Autowired
protected WebApplicationContext wac;

@Autowired
protected Filter springSecurityFilterChain;

protected void setup() {
    mockMvc = MockMvcBuilders
   .webAppContextSetup(wac)
   .addFilters(springSecurityFilterChain)
   .build();
}