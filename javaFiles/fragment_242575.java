nc = new NetConnection();
nc.addEventListener(NetStatusEvent.NET_STATUS, netStatusHandler);

private function netStatusHandler(event:NetStatusEvent):void {
       switch (event.info.code) {
            // do something with the event.info
       }
}