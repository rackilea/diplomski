msa.getMessage(code, args, aLocale);

    ArgumentCaptor<Object> captor = ArgumentCaptor.forClass(Object.class);
    Mockito.verify(mock).getMessage(Mockito.anyString(), (Object[]) captor.capture(), Mockito.any(Locale.class));

    List<Object> actualArgs = Arrays.asList((Object[]) captor.getValue());
    Assert.assertEquals(10, actualArgs.size());
    Assert.assertEquals("CHF", actualArgs.get(9));
}