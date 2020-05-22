columnMessage.setLabelProvider(new ColumnLabelProvider() {
        @Override
        public void update(ViewerCell cell) {
            ... as now
        }

        @Override
        public String getToolTipText(Object element)
        {
           // TODO return the tool tip text for 'element'
        }

        @Override
        public String getText(Object element)
        {
          // TODO get text from 'element'
        }
    });
}