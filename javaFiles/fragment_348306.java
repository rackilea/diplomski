u2 = userRepository.findOne(u2.getIdLogin());

    CreditCard ccNew = new CreditCard("77777");

    u2.addCreditCard(ccNew );// bidirectional happens here inside

    userRepository.saveAndFlush(u2); 

    Assert.assertEquals("User should have 2 credit cards.",
            1, u2.getCreditCardCollection().size()); // PASS

    Set<CreditCard> ccs = u2.getCreditCardCollection();
    for (CreditCard cc : ccs) {
        Assert.assertNotNull("CreditCard ID is null", cc.getIdCreditCard());
    }