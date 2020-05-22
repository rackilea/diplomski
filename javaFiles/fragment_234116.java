2019-04-18 15:47:36,950 DEBUG o.s.web.servlet.DispatcherServlet - Completed 404 NOT_FOUND, headers={} 
2019-04-18 15:47:36,958 DEBUG o.a.c.c.C.[Tomcat].[localhost] - Processing ErrorPage[errorCode=0, location=/error] 
2019-04-18 15:47:36,962 DEBUG o.a.catalina.core.StandardWrapper -   Returning non-STM instance 
2019-04-18 15:47:36,962 DEBUG s.d.s.w.PropertySourcedRequestMappingHandlerMapping - looking up handler for path: /error 
2019-04-18 15:47:36,968 DEBUG s.d.s.w.PropertySourcedRequestMappingHandlerMapping - looking up handler for path: /error 
2019-04-18 15:47:36,968 DEBUG s.d.s.w.PropertySourcedRequestMappingHandlerMapping - looking up handler for path: /error 
2019-04-18 15:47:36,969 DEBUG o.s.s.w.u.m.AntPathRequestMatcher - Checking match of request : '/error'; against '/v2/api-docs' 
2019-04-18 15:47:36,969 DEBUG o.s.s.w.u.m.AntPathRequestMatcher - Checking match of request : '/error'; against '/swagger-resources/configuration/ui' 
2019-04-18 15:47:36,969 DEBUG o.s.s.w.u.m.AntPathRequestMatcher - Checking match of request : '/error'; against '/swagger-resources' 
2019-04-18 15:47:36,969 DEBUG o.s.s.w.u.m.AntPathRequestMatcher - Checking match of request : '/error'; against '/swagger-resources/configuration/security' 
2019-04-18 15:47:36,969 DEBUG o.s.s.w.u.m.AntPathRequestMatcher - Checking match of request : '/error'; against '/swagger-ui.html' 
2019-04-18 15:47:36,969 DEBUG o.s.s.w.u.m.AntPathRequestMatcher - Checking match of request : '/error'; against '/webjars/**' 
2019-04-18 15:47:36,970 DEBUG o.s.security.web.FilterChainProxy - /error at position 1 of 11 in additional filter chain; firing Filter: 'WebAsyncManagerIntegrationFilter' 
2019-04-18 15:47:36,970 DEBUG o.s.security.web.FilterChainProxy - /error at position 2 of 11 in additional filter chain; firing Filter: 'SecurityContextPersistenceFilter' 
2019-04-18 15:47:36,970 DEBUG o.s.security.web.FilterChainProxy - /error at position 3 of 11 in additional filter chain; firing Filter: 'HeaderWriterFilter' 
2019-04-18 15:47:36,970 DEBUG o.s.security.web.FilterChainProxy - /error at position 4 of 11 in additional filter chain; firing Filter: 'LogoutFilter' 
2019-04-18 15:47:36,971 DEBUG o.s.s.w.u.matcher.OrRequestMatcher - Trying to match using Ant [pattern='/logout', GET] 
2019-04-18 15:47:36,971 DEBUG o.s.s.w.u.m.AntPathRequestMatcher - Checking match of request : '/error'; against '/logout' 
2019-04-18 15:47:36,971 DEBUG o.s.s.w.u.matcher.OrRequestMatcher - Trying to match using Ant [pattern='/logout', POST] 
2019-04-18 15:47:36,971 DEBUG o.s.s.w.u.m.AntPathRequestMatcher - Request 'GET /error' doesn't match 'POST /logout' 
2019-04-18 15:47:36,971 DEBUG o.s.s.w.u.matcher.OrRequestMatcher - Trying to match using Ant [pattern='/logout', PUT] 
2019-04-18 15:47:36,971 DEBUG o.s.s.w.u.m.AntPathRequestMatcher - Request 'GET /error' doesn't match 'PUT /logout' 
2019-04-18 15:47:36,971 DEBUG o.s.s.w.u.matcher.OrRequestMatcher - Trying to match using Ant [pattern='/logout', DELETE] 
2019-04-18 15:47:36,971 DEBUG o.s.s.w.u.m.AntPathRequestMatcher - Request 'GET /error' doesn't match 'DELETE /logout' 
2019-04-18 15:47:36,971 DEBUG o.s.s.w.u.matcher.OrRequestMatcher - No matches found 
2019-04-18 15:47:36,971 DEBUG o.s.security.web.FilterChainProxy - /error at position 5 of 11 in additional filter chain; firing Filter: 'OAuth2AuthenticationProcessingFilter' 
2019-04-18 15:47:36,971 DEBUG o.s.s.o.p.a.BearerTokenExtractor - Token not found in headers. Trying request parameters. 
2019-04-18 15:47:36,971 DEBUG o.s.s.o.p.a.BearerTokenExtractor - Token not found in request parameters.  Not an OAuth2 request. 
2019-04-18 15:47:36,971 DEBUG o.s.s.o.p.a.OAuth2AuthenticationProcessingFilter - No token in request, will continue chain. 
2019-04-18 15:47:36,971 DEBUG o.s.security.web.FilterChainProxy - /error at position 6 of 11 in additional filter chain; firing Filter: 'RequestCacheAwareFilter' 
2019-04-18 15:47:36,971 DEBUG o.s.security.web.FilterChainProxy - /error at position 7 of 11 in additional filter chain; firing Filter: 'SecurityContextHolderAwareRequestFilter' 
2019-04-18 15:47:36,972 DEBUG o.s.security.web.FilterChainProxy - /error at position 8 of 11 in additional filter chain; firing Filter: 'AnonymousAuthenticationFilter' 
2019-04-18 15:47:36,973 DEBUG o.s.s.w.a.AnonymousAuthenticationFilter - Populated SecurityContextHolder with anonymous token: 'org.springframework.security.authentication.AnonymousAuthenticationToken@c875a1a4: Principal: anonymousUser; Credentials: [PROTECTED]; Authenticated: true; Details: org.springframework.security.web.authentication.WebAuthenticationDetails@b364: RemoteIpAddress: 0:0:0:0:0:0:0:1; SessionId: null; Granted Authorities: ROLE_ANONYMOUS' 
2019-04-18 15:47:36,973 DEBUG o.s.security.web.FilterChainProxy - /error at position 9 of 11 in additional filter chain; firing Filter: 'SessionManagementFilter' 
2019-04-18 15:47:36,973 DEBUG o.s.security.web.FilterChainProxy - /error at position 10 of 11 in additional filter chain; firing Filter: 'ExceptionTranslationFilter' 
2019-04-18 15:47:36,973 DEBUG o.s.security.web.FilterChainProxy - /error at position 11 of 11 in additional filter chain; firing Filter: 'FilterSecurityInterceptor' 
2019-04-18 15:47:36,974 DEBUG o.s.s.w.a.i.FilterSecurityInterceptor - Secure object: FilterInvocation: URL: /error; Attributes: [#oauth2.throwOnError(authenticated)] 
2019-04-18 15:47:36,974 DEBUG o.s.s.w.a.i.FilterSecurityInterceptor - Previously Authenticated: org.springframework.security.authentication.AnonymousAuthenticationToken@c875a1a4: Principal: anonymousUser; Credentials: [PROTECTED]; Authenticated: true; Details: org.springframework.security.web.authentication.WebAuthenticationDetails@b364: RemoteIpAddress: 0:0:0:0:0:0:0:1; SessionId: null; Granted Authorities: ROLE_ANONYMOUS 
2019-04-18 15:47:36,979 DEBUG o.s.s.access.vote.AffirmativeBased - Voter: org.springframework.security.web.access.expression.WebExpressionVoter@789f882a, returned: -1 
2019-04-18 15:47:36,982 DEBUG o.s.b.a.a.listener.AuditListener - AuditEvent [timestamp=2019-04-18T13:47:36.981Z, principal=anonymousUser, type=AUTHORIZATION_FAILURE, data={details=org.springframework.security.web.authentication.WebAuthenticationDetails@b364: RemoteIpAddress: 0:0:0:0:0:0:0:1; SessionId: null, type=org.springframework.security.access.AccessDeniedException, message=Access is denied}] 
2019-04-18 15:47:36,982 DEBUG o.s.s.w.a.ExceptionTranslationFilter - Access is denied (user is anonymous); redirecting to authentication entry point 
org.springframework.security.access.AccessDeniedException: Access is denied
    at org.springframework.security.access.vote.AffirmativeBased.decide(AffirmativeBased.java:84)
    at org.springframework.security.access.intercept.AbstractSecurityInterceptor.beforeInvocation(AbstractSecurityInterceptor.java:233)
    at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.invoke(FilterSecurityInterceptor.java:124)
    at org.springframework.security.web.access.intercept.FilterSecurityInterceptor.doFilter(FilterSecurityInterceptor.java:91)
    at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)
    at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:119)
    at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)
    at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:137)
    at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)
    at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:111)
    at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)
    at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:170)
    at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)
    at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)
    at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)
    at org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter.doFilter(OAuth2AuthenticationProcessingFilter.java:176)
    at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)
    at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:116)
    at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101)
    at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)
    at org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:105)
    at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:101)
    at org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:334)
    at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:215)
    at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:178)
    at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:357)
    at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:270)
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
    at org.apache.catalina.core.ApplicationDispatcher.invoke(ApplicationDispatcher.java:712)
    at org.apache.catalina.core.ApplicationDispatcher.processRequest(ApplicationDispatcher.java:461)
    at org.apache.catalina.core.ApplicationDispatcher.doForward(ApplicationDispatcher.java:384)
    at org.apache.catalina.core.ApplicationDispatcher.forward(ApplicationDispatcher.java:312)
    at org.apache.catalina.core.StandardHostValve.custom(StandardHostValve.java:394)
    at org.apache.catalina.core.StandardHostValve.status(StandardHostValve.java:253)
    at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:175)
    at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)
    at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)
    at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)
    at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:408)
    at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66)
    at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:791)
    at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1417)
    at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
    at java.lang.Thread.run(Thread.java:748)