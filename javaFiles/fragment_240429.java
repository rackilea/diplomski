@Override
  public void performSetup() {
    MockitoAnnotations.initMocks(this);
    registerMockSingleton(ReferenceConceptHelper.class,mockReferenceConceptHelper);
    registerMockSingleton(ConceptClientFacade.class,mockConceptClientExternalFacade);
    fixValueConceptIntegration = new FixValueConceptIntegration();
  }

  @Override
  protected void performTearDown() throws Exception
  {
    fixValueConceptIntegration = null;
  }