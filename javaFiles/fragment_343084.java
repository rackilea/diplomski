[DEBUG,FilterChainProxy] Candidate is: '/secure/index.jsp?param=value'; pattern is /.*; matched=true
[DEBUG,FilterChainProxy] /secure/index.jsp?param=value at position 1 of 12 in additional filter chain; firing Filter: 'ConcurrentSessionFilter'
...
[DEBUG,FilterChainProxy] /secure/index.jsp?param=value at position 11 of 12 in additional filter chain; firing Filter: 'ExceptionTranslationFilter'
[DEBUG,FilterChainProxy] /secure/index.jsp?param=value at position 12 of 12 in additional filter chain; firing Filter: 'FilterSecurityInterceptor'
[DEBUG,ExpressionBasedFilterInvocationSecurityMetadataSource] Candidate is: '/secure/index.jsp?param=value'; pattern is \A/secure/extreme/.*\Z; matched=false
[DEBUG,ExpressionBasedFilterInvocationSecurityMetadataSource] Candidate is: '/secure/index.jsp?param=value'; pattern is \A/secure/index.jsp\?param=value\Z; matched=true
[DEBUG,FilterSecurityInterceptor] Secure object: FilterInvocation: URL: /secure/index.jsp?param=value; Attributes: [permitAll]