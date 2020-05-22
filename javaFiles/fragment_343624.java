Date mockDate = EasyMock.createMock(Date.class);
    final IPremium premium = EasyMock.createMock(IPremium.class);
    EasyMock.expect(premium.getCommencementDate()).andReturn(mockDate).anyTimes();
    expect(
            premium.getRemainingPremium(
                    (BigDecimal) EasyMock.anyObject(),
                    (Date) EasyMock.anyObject(),
                    (Date) EasyMock.anyObject(),
                    EasyMock.anyBoolean()
                    ))
                    .andReturn(BigDecimal.TEN).anyTimes();
    replay(premium);