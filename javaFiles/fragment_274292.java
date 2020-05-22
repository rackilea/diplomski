public void testSamResponseGood() {

  final SamResponse samResponse = new SamResponse();
  GoodResponse res = new GoodResponse();
  samResponse.setGoodResponse(res);


  new Expectations() {{ 

        webServiceUtility.getSamResponse(withInstanceOf(MyParam.class)); 
        result = samResponse ;
        times = 1;


    }};