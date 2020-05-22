public static function getRemoteObject(destination:String, channelName:String,
    showBusyCursor:Boolean=true):RemoteObject{
    var remoteService:RemoteObject=new RemoteObject(destination);
    var channelSet:ChannelSet=new ChannelSet();
    var url:String = Application(Application.application).url;
    var secure:Boolean = URLUtil.isHttpsURL(url);
    var protocol:String = URLUtil.getProtocol(url);
    var amf:AMFChannel;
    if (secure){
        amf = new SecureAMFChannel(channelName, protocol +
            "://{server.name}:{server.port}" +
            (Application.application as Application).parameters.contextRoot +
            "/graniteamf/amf");
    }else{
        amf = new AMFChannel(channelName, protocol +
            "://{server.name}:{server.port}" +
            (Application.application as Application).parameters.contextRoot
            + "/graniteamf/amf");
    }
    channelSet.addChannel(amf);
    remoteService.channelSet=channelSet;
    remoteService.showBusyCursor=showBusyCursor;
    return remoteService;
}