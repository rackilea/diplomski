MyParam params = new MyParams();
param.setAtt("test");
new Expectations() {{ 

        webServiceUtility.getSamResponse(params); 
        result = samResponse ;
        times = 1;


    }};