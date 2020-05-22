try {
    feedURL = new URL(request.getParameter("url"));
} catch (MalformedURLException e) {
    PrintWriter out = response.getWriter();
    out.println("Please go back and submit a valid URL.");
    return;
}