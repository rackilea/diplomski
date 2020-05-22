public class StringContentRequestHandler implements RequestHandler { 

private static final Logger logger = LoggerFactory.getLogger(RawContentRequestHandler.class); 

public Response handleRequest(Message m, ClassResourceInfo resourceClass) { 
    InputStream is = m.getContent(InputStream.class); 
    try { 
        CachedOutputStream bos = new CachedOutputStream(); 
        IOUtils.copy(is, bos); 

        bos.flush(); 
        is.close(); 

        m.setContent(InputStream.class, bos.getInputStream()); 
        StringBuilder builder = new StringBuilder(); 
        bos.writeCacheTo(builder, "utf-8"); 
        m.setContent(String.class, builder.toString()); 
        return null; 

    } catch (IOException ex) { 
        logger.error("IOException on getting raw content", ex); 
        return null; 
    } 
} 
}