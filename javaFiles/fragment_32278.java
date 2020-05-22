signalSimulator.execute();

        // ************* all these signalSimulator calls below ***********
        if (rdbtnSineWave.isSelected()) {
           data = signalSimulator.generateSineWave(numOfdataPoints,
                 noiseAmp, offset);
           data = signalSimulator.addAnomalies(data, numOfLocalSpikes,
                 numOfExpSpikes);
        } else { // Linear signal is selected
           data = signalSimulator.generateLinearSignal(numOfdataPoints,
                 noiseAmp, slope, offset);
           data = signalSimulator.addAnomalies(data, numOfLocalSpikes,
                 numOfExpSpikes);
        }

        signalSimulator.writeLogFile(path, ".txt", data);