scrollPane_.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener()
    {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e)
        {
            scrolledAmount_ = e.getValue();
            System.out.println("Type is "+e.getAdjustmentType());
            System.out.println("Amount scrolled is "+e.getValue());
            System.out.println("Scrolled amount is "+scrolledAmount_);
        }
    });