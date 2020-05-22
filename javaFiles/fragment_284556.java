JFreeChart chart = new JFreeChart(...);
chart.set ... // apply your series and options

MyLegend legend = new MyLegend();
legend.set... // apply your legend options if applicable
chart.setLegend(legend);