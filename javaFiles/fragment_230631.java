@Override
    public void stop() {
        SingleConnectionDataSource ds;
        ds=((SingleConnectionDataSource)AppUtil.getContext().getBean("dataSource"));
        ds.destroy();
        AppUtil.closeContext();
    }