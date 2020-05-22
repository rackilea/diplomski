@Test
public void testResponse_for_RequestWithoutCcid() throws IOException, ServletException {

HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
FilterChain filterChain = mock(FilterChain.class);
CorrelationIdServletFilter correlationIdServletFilter = new CorrelationIdServletFilter();

expect(httpServletRequest.getHeader(CORRELATION_ID_HEADER_NAME)).andReturn(""); // Empty correlation id in the request

Capture capturedCorrelationIdRaw = newCapture();

httpServletResponse.addHeader(CORRELATION_ID_HEADER_NAME, capture(capturedCorrelationIdRaw));
expectLastCall(); // used for void methods in EasyMock framework

filterChain.doFilter(httpServletRequest, httpServletResponse);
expectLastCall();

CorrelationIdServletFilter.doFilter(httpServletRequest, httpServletResponse,
    filterChain);


assertNotEmpty(capturedCorrelationIdRaw.getValue());


verify(httpServletRequest, times(1))
    .getHeader(CORRELATION_ID_HEADER_NAME);
verify(httpServletResponse, times(1))
    .addHeader(CORRELATION_ID_HEADER_NAME, anyString);

}