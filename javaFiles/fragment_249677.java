public class YouAction implements SessionAware{
    private Map<String, Object> sessionMap;
      @Override
        public void setSession(Map<String, Object> sessionMap) {
            this.sessionMap = sessionMap;
        }
    }