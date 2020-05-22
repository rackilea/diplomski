return show2(model, new HttpServletRequestWrapper(request) {
    public StringBuffer getRequestURL() {
        return new StringBuffer(
            super.getRequestURL().toString().replaceFirst("/show1$", "/show2"));
    }
});