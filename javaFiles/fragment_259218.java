Components.utils.import("resource://gre/modules/XPCOMUtils.jsm");
Components.utils.import("resource://gre/modules/Services.jsm");
transport.setEventSink({
  onTransportStatus: function(transport, status, progress, progressMax)
  {
    ...
  },
  QueryInterface: XPCOMUtils.generateQI([Components.interfaces.nsITransportEventSync])
}, Services.tm.currentThread);