doAnswer(new Answer<Object>(){
        @Override
        public Object answer(InvocationOnMock invocation){
           Object[] arguments = invocation.getArguments();
           Stuff argument = (Stuff) arguments[0];
           if(stuff.getName().equals("Tom")) {
              stuff.setName("yes");
           }
           else {
              stuff.setName("no");
           }
           return null;
        }
     }).when(mockObject).doThing(any(Stuff.class));