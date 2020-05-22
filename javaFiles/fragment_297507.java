for(int I = 0;  I < price.length();  I++)
    {
        JSONArray jArr = price.getJSONArray(I);
        values.add(new Entry((float) jArr.getDouble(0), (float) jArr.getDouble(1)));
    }

    // create a dataset and give it a type
    LineDataSet set1 = new LineDataSet(values, "DataSet 1");
    set1.setAxisDependency(AxisDependency.LEFT);
    set1.setColor(ColorTemplate.getHoloBlue());
    set1.setValueTextColor(ColorTemplate.getHoloBlue());
    set1.setLineWidth(1.5f);
    set1.setDrawCircles(false);
    set1.setDrawValues(false);
    set1.setFillAlpha(65);
    set1.setFillColor(ColorTemplate.getHoloBlue());
    set1.setHighLightColor(Color.rgb(244, 117, 117));
    set1.setDrawCircleHole(false);

    set1.setDrawFilled(true);

    // create a data object with the datasets
    final LineData data = new LineData(set1);
    data.setValueTextColor(Color.WHITE);
    data.setValueTextSize(9f);
    mChart.setData(data);