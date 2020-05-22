@Test
public void filterHeaderInjectionHappensLast() throws Exception {
    javax.servlet.Filter myFilter = new HeaderInjectionFilter();

    mockRequest = mock(javax.servlet.http.HttpServletRequest.class);
    mockResponse = mock(javax.servlet.http.HttpServletResponse.class);
    mockFilterChain = mock(javax.servlet.FilterChain.class);

    myFilter.doFilter(mockRequest, mockResponse, mockFilterChain);

    InOrder inOrder = inOrder(mockFilterChain, mockResponse);
    inOrder.verify(mockFilterChain).doFilter(mockRequest,mockResponse);
    inOrder.verify(mockResponse, times(2)).setHeader(any(String.class),any(String.class));    
}