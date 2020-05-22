@RenderMapping(params = "action=fail")
    public String fail() {
        LOG.info("\n#############Calling fail###########");
        return "<my_dir>/fail";

    }

@RenderMapping(params = "action=viewLogs")
    public String logs() {
        LOG.info("\n#############Calling logs###########");
        return "<my_dir>/logs";

    }