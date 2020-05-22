doAnswer((Answer<Void>) invocation -> {
        Object[] arguments = invocation.getArguments();
        if(arguments != null && arguments.length > 1 && arguments[0] != null && arguments[1] != null){
            Holder<String> eCodCreated = (Holder<String>) arguments[1];
            Holder<Integer> eReturn = (Holder<Integer>) arguments[3];
            Holder<String> eSocCreated = (Holder<String>) arguments[4];
            eReturn.value = 0;
            eCodCreated.value = "1239000";
            eSocCreated.value = "";
            }
            return null;
        }
    ).when(altaProxy).zwebserAltaDeudores(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());