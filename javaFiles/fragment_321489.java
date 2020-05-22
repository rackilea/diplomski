/*
     * Constructor
     */
    public SocketConnection(View primaryView, View secondaryView) {

        /*
         * For secondaryView
         */
        statusTextField = (TextField) secondaryView.lookup("#statusTextField");
        ipAddressTextField = (TextField) secondaryView.lookup("#ipAddressTextField");
        startSignalModeComboBox = (ComboBox<String>) secondaryView.lookup("#startSignalModeComboBox");
        predictHorizonTextField = (TextField) secondaryView.lookup("#predictHorizonTextField");
        controlHorizonTextField = (TextField) secondaryView.lookup("#controlHorizonTextField");
        sampleTimeTextField = (TextField) secondaryView.lookup("#sampleTimeTextField");
        pwmDutyCallTextField = (TextField) secondaryView.lookup("#pwmDutyCallTextField");
        endTimeOfStartSignalTextField = (TextField) secondaryView.lookup("#endTimeOfStartSignalTextField");
        referencePointTextField = (TextField) secondaryView.lookup("#referencePointTextField");
        portTextField = (TextField) secondaryView.lookup("#portTextField");

        /*
         * For primaryView
         */
        lineChart = (LineChart<String, Number>) primaryView.lookup("#lineChart");

        /*
         * Declare the data object inside the chart
         */
        time_output = new Series<String, Number>();
        lineChart.getData().add(time_output);


    }