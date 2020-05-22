NumberAxis axisLeft = new NumberAxis(plot.getRangeAxis().getLabel()) {
        @Override
        public List refreshTicks(
                Graphics2D g2, 
                AxisState state,
                Rectangle2D dataArea, 
                RectangleEdge edge) {

            List defaultTicks = super.refreshTicks(g2, state, dataArea, edge);
            List customTicks = new ArrayList();

            for (Object aTick : defaultTicks) {
                NumberTick currenttick = (NumberTick) aTick;

                customTicks.add(new NumberTick(
                        TickType.MINOR, 
                        currenttick.getValue(), 
                        "",  //empty
                        currenttick.getTextAnchor(), 
                        currenttick.getRotationAnchor(),
                        currenttick.getAngle()));
            }
            NumberTick aTick = (NumberTick) defaultTicks.get(0);
            for (double dTest : m_lPercentageValuesForY) {
                customTicks.add(new NumberTick(
                        TickType.MAJOR, 
                        dTest, 
                        String.format("%.0f%%", dTest * 100), //only wanted values are set to major
                        aTick.getTextAnchor(), 
                        aTick.getRotationAnchor(),
                        aTick.getAngle()));
            }
            return customTicks;
        }
    };
    plot.setRangeAxis(axisLeft);