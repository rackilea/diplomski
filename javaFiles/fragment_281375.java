$.getJSON("http://my.server.com/coordinates/?location=" + location,
  function(json) {
    for(var i = 0; i < json.list.length; i++){
      position = new Microsoft.Maps.Location(json.list[i].left,json.list[i].right);
      var pin = new Microsoft.Maps.Pushpin(position);
      pins.push(pin)
    }
}