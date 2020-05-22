@Component
class RequestWrapperFilter : Filter {
    override fun doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {
        val reqWrapper = ContentCachingRequestWrapper(req as HttpServletRequest)
        chain.doFilter(reqWrapper, res)
    }
}