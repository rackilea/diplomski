Chart chart = AWTChartComponentFactory.chart(Quality.Advanced, IChartComponentFactory.Toolkit.swing);   
ChartScene scene = chart.getScene();
AWTCameraMouseController controller = new AWTCameraMouseController(chart);
Component canvas = (Component) chart.getCanvas();
canvas.addMouseListener(controller);
canvas.addMouseMotionListener(controller);
canvas.addMouseWheelListener(controller);
centerPanel.add(canvas, BorderLayout.CENTER);