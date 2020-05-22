@Override
@Subscribe
public synchronized void handleConfigurationEvent(MaterializedConfiguration conf) {
    sourcesRef = conf.getSourceRunners();
    channelsRef = conf.getChannels();
    sinksRef = conf.getSinkRunners();
    super.handleConfigurationEvent(conf);
} // handleConfigurationEvent