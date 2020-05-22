add(new WebMarkupContainer("link")
{
    @Override
    protected void onComponentTag(ComponentTag tag)
    {
        super.onComponentTag(tag);

        PageParameters parameters = new PageParameters();
        parameters.add("sheet", "sheet1");
        parameters.add("format", "A4");
        tag.put("href", urlFor(new MapperDemoResourceReference(), parameters));
    }
});