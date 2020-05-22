public JPanel getChartPanel(){

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrepareChart chart = new PrepareChart(); 
                System.out.println("In caht getter methoed");
                chart.start();
            }
        });
        return new ChartPanel(chart);
    }