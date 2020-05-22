@Before
public void setUp() {
    this.documentConfig = new DocumentConfig();
    this.documentConfig.setNameRequired(false);
    this.service = new DocumentService(this.documentConfig);
}