public static GoPiGo3 Instance() throws IOException, FirmwareVersionException{
    if (_instance == null) {
        _instance = new GoPiGo3(8, true);
    }
    return _instance;
}

public static GoPiGo3 Instance(int addr) throws IOException, FirmwareVersionException{
    if (_instance == null) {
        _instance = new GoPiGo3(addr, true);
    }
        return _instance;
}

public static GoPiGo3 Instance(boolean detect) throws IOException, FirmwareVersionException{
    if (_instance == null) {
        _instance = new GoPiGo3(8, detect);
    }
    return _instance;
}

public static GoPiGo3 Instance(int addr, boolean detect) throws IOException, FirmwareVersionException{
    if (_instance == null) {
        _instance = new GoPiGo3(addr, detect);
    }
    return _instance;
}