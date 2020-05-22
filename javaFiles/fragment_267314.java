@Test
    public void renamingToArbitraryMethodName() throws Exception {
        ZonedDateTime current = ZonedDateTime.now();
        ZonedDateTime mockMidNight = ZonedDateTime.of(current.getYear(), current.getMonthValue(),
                                                      current.getDayOfMonth(), 0, 0, 0, 0, ZoneId.of("US/Eastern"));

        PowerMockito.mockStatic(ZonedDateTime.class);
        PowerMockito.when(ZonedDateTime.ofInstant(anyObject(), anyObject())).thenReturn(mockTime);
    }