@Bean public ConcurrentSessionFilter concurrentSessionFilter() {

    ConcurrentSessionFilter c = new ConcurrentSessionFilter(sessionRegistry(), new SessionInformationExpiredStrategy() {

        @Override
        public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {

            HttpServletRequest request = event.getRequest();
            HttpServletResponse response = event.getResponse();
            SessionInformation info = event.getSessionInformation();

            redirectStrategy().sendRedirect(request, response, "/ejercicios-programacion/");

        }
    });

    return c;

}