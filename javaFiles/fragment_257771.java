when(rt.exchange(anyString(), any(HttpMethod.class), any(), any()))
  .thenAnswer((invocation) -> {
     Object paramToCheck = invocation.getArguments()[3];

     if(paramToCheck instanceof String){
       return response;
     }else if (paramToCheck instanceof InfsEspecificasDTO){
       return responseInfoEsp;
     }

     return null;

  });