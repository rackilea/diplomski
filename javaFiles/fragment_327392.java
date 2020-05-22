public void doView(RenderRequest req, RenderResponse res) throws IOException,
PortletException {

    PortletRequestDispatcher prd =
        getPortletContext().getRequestDispatcher("/WEB-INF/jsp/view.jsp");
    prd.include(req, res);
}