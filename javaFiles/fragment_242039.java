InvientChartsConfig chartConfig = new InvientChartsConfig();
chartConfig.getTitle().setText("Sales");
chartConfig.getGeneralChartConfig().setType(SeriesType.PIE);

SalesChat chart = new SalesChat(chartConfig);
chart.build();

VerticalLayout layout = new VerticalLayout();
layout.addComponent(chart);