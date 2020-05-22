@Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            /*some actions to define the right authMethod to use*/
            switch (authMethod) {
                case FIRST:
                    firstFilter.doFilter(servletRequest, servletResponse, filterChain);
                    break;
                case SECOND:
                    secondFilter.doFilter(servletRequest, servletResponse, filterChain);
                    break;
                case THIRD:
                    thirdFilter.doFilter(servletRequest, servletResponse, filterChain);
                    break;
                default:
                    /* throws exception */ break;
            }
        }