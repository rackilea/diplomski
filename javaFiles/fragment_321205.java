XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();

            double[] range = {0 , 5 , 0 , 5};
            mRenderer.setMargins(marign);
            mRenderer.setAxisTitleTextSize(axisTextSize);
            mRenderer.setChartTitleTextSize(chartTextSize);
            mRenderer.setLabelsTextSize(axisTextSize);
            mRenderer.setLegendTextSize(legendTextSize);
            // multiRenderer.setLegendHeight(40);
            //when we dealing with one bar with one series , it is good to not deal with barSpacing() and setBarWidth()
            //multiRenderer.setBarSpacing(-0.1);
            //multiRenderer.setBarWidth((int)(context.getResources().getDimension(R.dimen.chart_bar_width)));

            //multiRenderer.setBarWidth(50);
            mRenderer.setAxesColor(Color.parseColor("#2c2c2c"));
            mRenderer.setInitialRange(range, 1);
            mRenderer.setXAxisMin(0.4);
            mRenderer.setXAxisMax(6);
            mRenderer.setXLabels(0);
            //multiRenderer.setXAxisMax(15);
            //multiRenderer.setYAxisMin(0);
            mRenderer.setXLabelsAlign(Align.CENTER);
            mRenderer.setYLabelsAlign(Align.RIGHT);

            mRenderer.setPanEnabled(true,false);
            mRenderer.setZoomEnabled(false, false);
            mRenderer.setPanLimits(new double[]{0,18,0,0});
            mRenderer.setApplyBackgroundColor(true);
            mRenderer.setMarginsColor(Color.WHITE);
            mRenderer.setBackgroundColor(Color.argb(0x00, 0x01, 0x01, 0x01));
            //multiRenderer.setMarginsColor(Color.parseColor("#FF000000"));

            mRenderer.setXTitle(getxTItle());
            mRenderer.setYTitle(getyTItle());
            mRenderer.setXLabelsPadding(10);
            mRenderer.setYLabelsPadding(10);
            mRenderer.setXLabelsColor(Color.parseColor("#2c2c2c"));
            mRenderer.setYLabelsColor(0, Color.parseColor("#2c2c2c"));   
            mRenderer.setLabelsColor(Color.parseColor("#2c2c2c"));
            mRenderer.setShowCustomTextGridY(true);
            mRenderer.setGridColor(Color.parseColor("#2c2c2c"));
            mRenderer.setPointSize(20.5f);
            mRenderer.setInScroll(true);