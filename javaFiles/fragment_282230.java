public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
    response.setContentType("application/pdf");
    OutputStream out = response.getOutputStream();
    try {
        // generate the PDF
    } finally {
        out.close();
    }
    return null;
 }