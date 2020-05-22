@Provides
DeviceInfo provideDeviceInfo(){
    return new DeviceInfo();
}

@Provides
Analytics provideAnalytics(DeviceInfo deviceInfo){
    return new Analytics(deviceInfo, [... other parameters]);
}