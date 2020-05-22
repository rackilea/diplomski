@Override
protected void doPost(HttpServletRequest request, HttpServletResponse resp)
        throws ServletException, IOException 
{
        // (....)
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        FileItemIterator it = sfu.getItemIterator(request);
        // TAKE THE FIRST PART FROM REQUEST (HERE COMES THE FILE)
        if (it.hasNext())
        {
            FileItemStream fis = it.next();
            // grab data from fis (content type, name)
            ...fis.getContentType()...
            ...fis.getName()...
            // GET CONTENT LENGTH SEARCH FOR THE LENGTH HEADER
            ...getContentLength(fis.getHeaders(), request)...
            // here I use an own method to process data
            // but FileItemStream has an openStream method
            FileItem item = processUpload(factory, fis, uploadInfo);
            (....)
        }



private long getContentLength(FileItemHeaders pHeaders, HttpServletRequest request)
{
    try
    {
        return Long.parseLong(pHeaders.getHeader("Content-length"));
    }
    catch (Exception e)
    {
                    // if I can't grab the value return an approximate (in my case I don't care)
        return request.getContentLength();
    }
}