Bar bar1 = new Bar(tChart1.getChart());
    bar1.fillSampleValues();

    tChart1.addChartPaintListener(new ChartPaintAdapter() {

        @Override
        public void chartPainted(ChartDrawEvent e) {

            String leftText = "Left Axis Title";
            String bottomText = "Bottom Axis Title";

            int YMid = tChart1.getChart().getChartRect().y + (tChart1.getChart().getChartRect().height / 2);
            int XMid = tChart1.getChart().getChartRect().x + (tChart1.getChart().getChartRect().width / 2);

            tChart1.getGraphics3D().setFont(tChart1.getAxes().getLeft().getTitle().getFont());
            int leftHeight = tChart1.getGraphics3D().textWidth(leftText);
            tChart1.getGraphics3D().rotateLabel(10, YMid + (leftHeight / 2), leftText, 90);

            tChart1.getGraphics3D().setFont(tChart1.getAxes().getBottom().getTitle().getFont());
            int bottomWidth = tChart1.getGraphics3D().textWidth(bottomText);
            tChart1.getGraphics3D().textOut(XMid - (bottomWidth / 2), tChart1.getHeight() - 20, bottomText);
        }
    });

    tChart1.getPanel().setMarginLeft(10);
    tChart1.getPanel().setMarginBottom(10);