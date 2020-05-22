public class MyRequestDumperFilter extends RequestDumperFilter{
        private Boolean enabled;

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public Boolean getEnabled() {
            return enabled;
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            if (enabled) {
                super.doFilter(request, response, chain);
            }
            else {
                chain.doFilter(request,response);
            }
        }
    }