SwitchPlugin() {
    UnregisterNatives();
    unloadPlugin(oldHandle);
    newHandle = loadPlugin(newPluginName);
    RegisterNatives();
}