class JWTAuthenticationFilter
(private val authManager: AuthenticationManager, private var jwtUtil: JWTUtil) : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        try {
            val username = obtainUsername(request)
            val password = obtainPassword(request)
            val token = UsernamePasswordAuthenticationToken(username, password)
            SecurityContextHolder.getContext().authentication = token
            successHandler.onAuthenticationSuccess(request, response, token)

            return authManager.authenticate(token)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}