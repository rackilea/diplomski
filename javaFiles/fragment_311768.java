// Media pipeline
    pipeline = kurento.createMediaPipeline();


    Composite composite = new Composite.Builder(pipeline).build();

    HubPort hubPort1 = new HubPort.Builder(composite).build();
    HubPort hubPort2 = new HubPort.Builder(composite).build();
    HubPort hubPort3 = new HubPort.Builder(composite).build();

    recorderEP =  new RecorderEndpoint.Builder(pipeline, RECORDING_PATH + "twosidess" + RECORDING_EXT).build();

    webRtcCaller.connect(webRtcCallee);
    webRtcCaller.connect(recorderEP);

    webRtcCaller.connect(hubPort1);
    webRtcCallee.connect(hubPort2);

    webRtcCallee.connect(webRtcCaller);

    hubPort3.connect(recorderEP);
    recorderEP.record();