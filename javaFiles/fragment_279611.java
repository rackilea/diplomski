@Override
public void handle(String path, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
{
    ...
    try
    {
        Handler handler = getHandler();
        if (handler!=null && _shutdown.get()==null && isStarted())
            handler.handle(path, baseRequest, request, response);
        else if (baseRequest.isHandled())
        {
            if (_wrapWarning.compareAndSet(false,true))
                LOG.warn("Bad statistics configuration. Latencies will be incorrect in {}",this);
        }
        else
        {
            baseRequest.setHandled(true);
            response.sendError(HttpStatus.SERVICE_UNAVAILABLE_503); // Change this line!
        }
    }
    finally
    {
        ...
    }
}