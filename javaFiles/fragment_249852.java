public class JsonPCallbackFilter extends OncePerRequestFilter {

    Logger logger = Logger.getLogger(JsonPCallbackFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        //logger.debug("Filter: "+request.getRequestURI());

        @SuppressWarnings("unchecked")
        Map<String, String[]> parms = request.getParameterMap();

        if(parms.containsKey("callback")) {
            logger.debug("Wrapping response with JSONP callback '" + parms.get("callback")[0] + "'");

            OutputStream out = response.getOutputStream();

            ByteResponseWrapper wrapper = new ByteResponseWrapper(response);

            chain.doFilter(request, wrapper);

            StringBuffer sb = new StringBuffer();
            sb.append(parms.get("callback")[0] + "(");
            sb.append(new String(wrapper.getBytes()));
            sb.append(new String(");"));

            out.write(sb.toString().getBytes());

            wrapper.setContentType("text/javascript;charset=UTF-8");
            response.setContentLength(sb.length());

            out.close();
        } else {
            chain.doFilter(request, response);
        }
    }
}

static class ByteOutputStream extends ServletOutputStream {
    private ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Override
    public void write(int b) throws IOException {
       bos.write(b);            
    }

    public byte[] getBytes() {
       return bos.toByteArray();
    }
}

static class ByteResponseWrapper extends HttpServletResponseWrapper {
   private PrintWriter writer;
   private ByteOutputStream output;

   public byte[] getBytes() {
      writer.flush();
      return output.getBytes();
   }

   public ByteResponseWrapper(HttpServletResponse response) {
      super(response);
      output = new ByteOutputStream();
      writer = new PrintWriter(output);
   }

@Override
public PrintWriter getWriter() {
    return writer;
}

@Override
public ServletOutputStream getOutputStream() throws IOException {
    return output;
   }
}

    <filter>
      <filter-name>jsonpFilter</filter-name>
      <filter-class>com.blahblah.JsonPCallbackFilter</filter-class>
    </filter>

    <filter-mapping>
      <filter-name>jsonpFilter</filter-name>
      <url-pattern>/*</url-pattern>
    </filter-mapping>