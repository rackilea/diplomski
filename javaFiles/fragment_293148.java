tChart1.getAspect().setView3D(false);
    tChart1.getLegend().setVisible(false);

    Candle candle1 = new Candle(tChart1.getChart());

    candle1.fillSampleValues(80);

    DateTime dt = DateTime.getNow();
    for (int i = 0; i < candle1.getCount(); i++) {
        candle1.getXValues().setValue(i, dt.toDouble());
        dt.add(Calendar.MINUTE, 1);            
    }

    //tChart1.getAxes().getBottom().setIncrement(DateTimeStep.FIVEMINUTES);
    tChart1.getAxes().getBottom().getLabels().setDateTimeFormat("hh:mm");

    AxisBreaksTool axisBreaksTool1 = new AxisBreaksTool(tChart1.getAxes().getBottom());

    for (int i=0; i<3; i++) {
        AxisBreak axisBreak1 = new AxisBreak(axisBreaksTool1);
        axisBreak1.setStartValue(candle1.getXValues().getValue(10*(i+1))-0.6);
        axisBreak1.setEndValue(candle1.getXValues().getValue(10*(i+1)+5)+0.6);
        axisBreak1.setStyle(AxisBreakStyle.LINE);
        axisBreaksTool1.getBreaks().add(axisBreak1);
    }

    Annotation annotation1 = new Annotation(tChart1.getChart());
    annotation1.setText("My Text");
    annotation1.setLeft(10);
    annotation1.setTop(10);