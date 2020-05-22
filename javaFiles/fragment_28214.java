@Autowired
    @InjectMocks
    private LocalDateConverter localDateConverter;

    @Autowired
    @Spy
    private FacesComponent facesComponent;
...
...
MockitoAnnotations.initMocks(this);
Mockito.doReturn(null).when(facesComponent).getLocaleFromFrontend();