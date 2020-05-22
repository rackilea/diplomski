@Autowired
    private StringToRoleConverter stringToRoleConverter;

    @Before
    public void init() {
        FormattingConversionService cs = new FormattingConversionService();
        cs.addConverter(stringToRoleConverter);

        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setConversionService(cs)
                .build();
    }