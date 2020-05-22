tChart1.addChartPaintListener(new ChartPaintAdapter() {

        @Override
        public void chartPainted(ChartDrawEvent e) {
            Candle candle1 = (Candle)tChart1.getSeries(0);
            double onePxWidth = tChart1.getAxes().getBottom().calcPosPoint(1) - tChart1.getAxes().getBottom().calcPosPoint(0); 
            double tmpWidthLeft = onePxWidth*(candle1.getCandleWidth()/2 + 4);
            double tmpWidthRight = onePxWidth*(candle1.getCandleWidth()/2 + 3);

            AxisBreaksTool axisBreaksTool1 = (AxisBreaksTool)tChart1.getTools().getTool(0);
            for (int i=0; i<axisBreaksTool1.getBreaks().size(); i++) {
                AxisBreak axisBreak1 = axisBreaksTool1.getBreaks().get(i);
                axisBreak1.setStartValue(candle1.getXValues().getValue(10*(i+1))+tmpWidthLeft);
                axisBreak1.setEndValue(candle1.getXValues().getValue(10*(i+1)+5)-tmpWidthRight);
            }
        }
    });