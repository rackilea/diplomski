@Mock private HttpSession mockHttpSession;
Map<String,Object> attributes = new HashMap<String,Object>();

@Test
public void theTestMethod() {

    Mockito.doAnswer(new Answer<Object>(){
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            String key = (String) invocation.getArguments()[0];
            return attributes.get(key);
        }
    }).when(mockHttpSession).getAttribute(anyString());

    Mockito.doAnswer(new Answer<Object>(){
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            String key = (String) invocation.getArguments()[0];
            Object value = invocation.getArguments()[1];
            attributes.put(key, value);
            return null;
        }
    }).when(mockHttpSession).setAttribute(anyString(), any());