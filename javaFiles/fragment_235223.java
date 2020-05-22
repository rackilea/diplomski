public class XSSSanitizeFilters implements Filter {
            @Override
        public void destroy() {
        }

        @Override
        public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) arg0;
            HttpServletResponse response = (HttpServletResponse) arg1;
            SanitizationRequestWrapper sanitizeRequest = new SanitizationRequestWrapper(request);
                if (null != sanitizeRequest.getBody()) {
                    try {
                        sanitizeJson(sanitizeRequest);
                    } catch (ParseException e) {
                        LOG.error("Unable to Sanitize the provided JSON .");
                    }
                    arg2.doFilter(sanitizeRequest, arg1);

                } else {
                    arg2.doFilter(arg0, arg1);
                }       
        }

        public void init(FilterConfig filterConfig) throws ServletException {

        }

        private void sanitizeJson(SanitizationRequestWrapper sanitizeRequest ) throws IOException, ParseException {
                JSONParser parser= new JSONParser();
                Object obj = parser.parse(sanitizeRequest.getReader());
                Map <String, Object> map = convertToMap((JSONObject)obj);
                sanitizeRequest.setBody((new JSONObject(map)).toString().getBytes());
        }

        public Map<String, Object> convertToMap(JSONObject jsonObject) {
            Map<String, Object> map = new HashMap<>();
            List<Object> mapArr = null;
            for (Object key : jsonObject.keySet()) {
                if (jsonObject.get(key) instanceof JSONObject) {
                    map.put((String) key, convertToMap((JSONObject) jsonObject.get(key)));
                } else if (jsonObject.get(key) instanceof JSONArray) {
                    mapArr = new ArrayList<Object>();
                    JSONArray jArray = (JSONArray) jsonObject.get(key);
                    for (int i = 0; i < jArray.size(); i++) {
                        if (jArray.get(i) instanceof JSONObject || jArray.get(i) instanceof JSONArray) {
                            mapArr.add(convertToMap((JSONObject) jArray.get(i)));
                        } else {
                            mapArr.add(jArray.get(i));
                        }
                    }
                    map.put((String) key, mapArr);
                } else {
                   // map.put((String) key, XssSanitizerUtil.stripXSS(jsonObject.get(key).toString()));
                    map.put((String) key, StringEscapeUtils.escapeHtml(jsonObject.get(key).toString()));

                }
            }
            return map;
        }
    }