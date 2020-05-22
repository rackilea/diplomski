public class SimpleViz implements EntryPoint {
              public void onModuleLoad() {
                // Create a callback to be called when the visualization API
                // has been loaded.
                Runnable onLoadCallback = new Runnable() {
                  public void run() {
                    Panel panel = RootPanel.get();

                    MotionChart chart = new MotionChart(createTable(), createOptions());

                    panel.add(chart);
                  }
                };
                VisualizationUtils.loadVisualizationApi(onLoadCallback, MotionChart.PACKAGE);
              }

              private Options createOptions() {
                Options options = Options.create();
                options.setWidth(600);
                options.setHeight(300);
                options.setTitle("My Motion Chart");

                //  Passing JSON state with escaped double quotes to options class. 
                options.setState("{\"orderedByY\":false,\"showTrails\":true,\"dimensions\":{\"iconDimensions\":[\"dim0\"]},\"yAxisOption\":\"3\",\"xZoomedIn\":false,\"time\":\"1988-04-16\",\"yZoomedIn\":false,\"xAxisOption\":\"2\",\"yZoomedDataMin\":150,\"yZoomedDataMax\":617,\"xZoomedDataMin\":300,\"uniColorForNonSelected\":false,\"xLambda\":1,\"playDuration\":15000,\"yLambda\":1,\"duration\":{\"timeUnit\":\"D\",\"multiplier\":1},\"iconType\":\"BUBBLE\",\"iconKeySettings\":[{\"trailStart\":\"1988\",\"key\":{\"dim0\":\"Apples\"}},{\"trailStart\":\"1988\",\"key\":{\"dim0\":\"Oranges\"}},{\"trailStart\":\"1988\",\"key\":{\"dim0\":\"Bananas\"}}],\"colorOption\":\"2\",\"xZoomedDataMax\":1200,\"nonSelectedAlpha\":0.4,\"orderedByX\":false,\"sizeOption\":\"_UNISIZE\"}");
                return options;
              }

              private AbstractDataTable createTable() {
                DataTable data = DataTable.create();
                    data.addColumn('string', 'Fruit');
                    data.addColumn('date', 'Date');
                    data.addColumn('number', 'Sales');
                    data.addColumn('number', 'Expenses');
                    data.addColumn('string', 'Location');
                data.addColumn(ColumnType.STRING, "Fruit");
                data.addColumn(ColumnType.DATE, "Date");
                data.addColumn(ColumnType.NUMBER, "Sales");
                data.addColumn(ColumnType.NUMBER, "Expenses");
                data.addColumn(ColumnType.STRING, "Location");
                data.addRows(6);
                 data.setValue(0, 0, "Apples");
                data.setValue(0, 1, new Date (1988,0,1));
                data.setValue(0, 2, 1000);
                data.setValue(0, 3, 300);
                data.setValue(0, 4, "East");
                 data.setValue(1, 0, "Oranges");
                data.setValue(1, 1, new Date (1988,0,1));
                data.setValue(1, 2, 1150);
                data.setValue(1, 3, 200);
                data.setValue(1, 4, "West");
                 data.setValue(2, 0, "Bananas");
                data.setValue(2, 1, new Date (1988,0,1));
                data.setValue(2, 2, 300);
                data.setValue(2, 3, 250);
                data.setValue(2, 4, "West");
                 data.setValue(3, 0, "Apples");
                data.setValue(3, 1, new Date (1989,6,1));
                data.setValue(3, 2, 1200);
                data.setValue(3, 3, 400);
                data.setValue(3, 4, "East");
                 data.setValue(4, 0, "Oranges");
                data.setValue(4, 1, new Date (1989,6,1));
                data.setValue(4, 2, 750);
                data.setValue(4, 3, 150);
                data.setValue(4, 4, "West");
                 data.setValue(5, 0, "Bananas");
                data.setValue(5, 1, new Date (1989,6,1));
                data.setValue(5, 2, 788);
                data.setValue(5, 3, 617);
                data.setValue(5, 4, "West");
                return data;
     }
}