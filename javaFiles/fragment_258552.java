if (typeof MozWebSocket != "undefined") { // window.MozWebSocket or "MozWebSocket" in window
    ok
  } else if (window.WebSocket) {  // he uses  if ("WebSocket" in window)
    ok
  } else {
    do your print "browser doesn't support websockets"
  }
  .... then if the browser supports websockets
  websocket = new WebSocket(app.url); or
  websocket = new MozWebSocket(app.url); 
  // depending on which it is.