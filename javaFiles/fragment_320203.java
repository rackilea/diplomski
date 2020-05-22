Number xValue = DatasetUtilities.findMinimumDomainValue(dataset);
    for (int seriesIndex = 0 ; seriesIndex < dataset.getSeriesCount() ; seriesIndex++){
        for (int itemIndex = 0 ; itemIndex < dataset.getItemCount(seriesIndex) ; itemIndex ++){
            Number yValue = dataset.getY(seriesIndex, itemIndex);
            if (yValue.equals(maximum)){
                if (dataset.getX(seriesIndex, itemIndex).floatValue() > xValue.floatValue())
                    xValue = dataset.getX(seriesIndex, itemIndex);
            }
        }
    }
    ValueMarker maxX = new ValueMarker(xValue.floatValue());
    maxX.setPaint(Color.red);
    maxX.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
    plot.addDomainMarker(maxX,Layer.BACKGROUND);