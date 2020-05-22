if (timeseriesArea.getPriceWeight() > 0) {
        XYPlot pricePlot = createPricePlot();
        combinedDomainXYPlot
                .add(pricePlot, timeseriesArea.getPriceWeight());
    }

    if (timeseriesArea.getVolumeWeight() > 0) {
        XYPlot volumePlot = createVolumePlot();
        combinedDomainXYPlot.add(volumePlot, timeseriesArea
                .getVolumeWeight());
    }

    if (timeseriesArea.getPriceWeight() > 0) {
        XYPlot pricePlot2 = createPricePlot();
        combinedDomainXYPlot
                .add(pricePlot2, timeseriesArea.getPriceWeight());
    }