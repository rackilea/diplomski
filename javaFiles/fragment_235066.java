clientBuilder.setKeepAliveStrategy(new ConnectionKeepAliveStrategy() {

        @Override
        public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
            // TODO Auto-generated method stub
            return 3*60*1000;
        }
    });