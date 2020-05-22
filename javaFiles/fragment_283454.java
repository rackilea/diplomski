Mockito.when(mockData.getPremium(Matchers.any(PanicLevel.class)))
    .thenAnswer(new Answer<Double>() {
        @Override
        public Double answer(InvocationOnMock arg0) throws Throwable {
          PanelLevel panicLevel = (PanicLevel) arg0.getArguments()[0];
          return premiums.get(panicLevel);
        }        
    });