feetAxis = new NumberAxis("Height [ft]");
metersAxis = new NumberAxis("Height [m]");
pathPlot.setRangeAxis(0, metersAxis);
pathPlot.setRangeAxis(1, feetAxis);

metersAxis.addChangeListener(new AxisChangeListener() {

   @Override
   public void axisChanged(AxisChangeEvent event) {

       SwingUtilities.invokeLater(new Runnable() {

           @Override
           public void run() {
               feetAxis.setRange(metersAxis.getLowerBound() * MetersToFeet, metersAxis.getUpperBound() * MetersToFeet);
                }
           });
       }
   });