final BorderLayout layout = new BorderLayout()
    {
        @Override
        protected CollapsePanel createCollapsePanel(final ContentPanel panel, final BorderLayoutData data)
        {
            final CollapsePanel result = super.createCollapsePanel(panel, data);

            result.sinkEvents(Events.Change.getEventCode());
            panel.getHeader().addListener(Events.Change, new Listener<BaseEvent>()
            {
                @Override
                public void handleEvent(BaseEvent be)
                {
                    result.getElement().getElementsByTagName("span").getItem(0).setInnerText(panel.getHeading());
                    PcTreeUI.this.layout(true);
                }
            });
            result.setTitle(panel.getHeading());
            return result;
        }
    };