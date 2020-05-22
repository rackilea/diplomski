public ResultMatcher doesNotExist() {
    return new ResultMatcher() {
        @Override
        public void match(MvcResult result) throws Exception {
            jsonPathHelper.doesNotExist(getContent(result)); // returns void
        }
    };
}