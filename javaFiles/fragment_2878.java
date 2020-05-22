IProcess process = DebugPlugin.newProcess(launch, process, "", null);
IStreamsProxy streamsProxy = process.getStreamsProxy();
IStreamMonitor streamMonitor = streamsProxy.getOutputStreamMonitor();

IStreamListener yourListener = ....;

streamMonitor.addListener(yourListener );