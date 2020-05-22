public class LinkTargetBlankPanel extends Panel
{
    private static final long serialVersionUID = -6527814402202345257L;

    public LinkTargetBlankPanel(String id, String url, String label)
    {
        super(id);
        add(new ExternalLink("link", url, label)
        {
            private static final long serialVersionUID = -8010560272317354356L;

            @Override
            protected void onComponentTag(ComponentTag tag)
            {
                super.onComponentTag(tag);
                tag.put("target", "_blank");
            }
        });
    }
}