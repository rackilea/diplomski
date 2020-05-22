columns.add(new AbstractColumn<WebService, String>(Model.of(" "))
{
    @Override
    public void populateItem(Item<ICellPopulator<WebService>> cellItem, String componentId,
            IModel<WebService> serviceModel)
    {
        String url = "http://www.geodata.com/map?service=WMS&request=GetCapabilities";
        cellItem.add(new LinkTargetBlankPanel("link", url, "GetCapabilities"));
    }
});