// I'm using jQuery here 
$.fn.serializeObject = function() {
  var arrayData, objectData;
  arrayData = this.serializeArray();
  objectData = {};

  $.each(arrayData, function() {
    var value;

    if (this.value != null) {
      value = this.value;
    } else {
      value = '';
    }

    // search for "parent.id" like attribute
    if (this.name.indexOf('.') != -1) {
      var attrs = this.name.split('.');
      var tx = objectData;

      for (var i = 0; i < attrs.length - 1; i++) {
        if (objectData[attrs[i]] == undefined)
          objectData[attrs[i]] = {};
        tx = objectData[attrs[i]];
      }
      tx[attrs[attrs.length - 1]] = value;
    } else {
      if (objectData[this.name] != null) {
        if (!objectData[this.name].push) {
          objectData[this.name] = [objectData[this.name]];
        }

        objectData[this.name].push(value);
      } else {
        objectData[this.name] = value;
      }
    }
  });

  return objectData;
};