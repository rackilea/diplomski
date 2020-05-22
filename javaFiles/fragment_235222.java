public class SanitizationRequestWrapper extends HttpServletRequestWrapper {

        public byte[] getBody() {
            return body;
        }

        public void setBody(byte[] body) {
            this.body = body;
        }

        private byte[] body;

        public SanitizationRequestWrapper(HttpServletRequest request) throws IOException {
            super(request);
            try {
                body = IOUtils.toByteArray(super.getInputStream());
            }catch (NullPointerException e){

            }
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            return new ServletInputStreamImpl(new ByteArrayInputStream(body));
        }

        @Override
        public BufferedReader getReader() throws IOException {
            String enc = getCharacterEncoding();
            if (enc == null) enc = "UTF-8";
            return new BufferedReader(new InputStreamReader(getInputStream(), enc));
        }

        private class ServletInputStreamImpl extends ServletInputStream {

            private InputStream is;

            public ServletInputStreamImpl(InputStream is) {
                this.is = is;
            }

            public int read() throws IOException {
                return is.read();
            }

            public boolean markSupported() {
                return false;
            }

            public synchronized void mark(int i) {
                throw new RuntimeException(new IOException("mark/reset not supported"));
            }

            public synchronized void reset() throws IOException {
                throw new IOException("mark/reset not supported");
            }
        }
    }