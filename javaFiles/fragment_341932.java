class DetachCheckingRequestAdapter extends RequestAdapter
{
    public DetachCheckingRequestAdapter(IPageManagerContext context)
    {
        super(context);
    }

    @Override
    protected void storeTouchedPages(List<IManageablePage> touchedPages)
    {
        super.storeTouchedPages(touchedPages);
        if (Application.get().usesDevelopmentConfig())
        {
            for (IManageablePage curPage : touchedPages)
            {
                if (!((Page) curPage).isErrorPage())
                    testDetachedObjects(curPage);
            }
        }
    }

    private void testDetachedObjects(final IManageablePage page)
    {
        try
        {
            NotSerializableException exception = new NotSerializableException();
            EntityAndSerializableChecker checker = new EntityAndSerializableChecker(exception);
            checker.writeObject(page);
        }
        catch (Exception ex)
        {
            log.error("Couldn't test/serialize the Page: " + page + ", error: " + ex);
            Session.get().setDetachException(ex);
        }
    }
}