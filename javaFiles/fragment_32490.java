if (typeof data.data === 'string') {
      buf = new Uint8ClampedArray(parseInt(data.data));
      count = 0;
      chunks = [];
      console.log('Expecting a total of ' + buf.byteLength + ' bytes');
      return;
    }
    var imgdata = new Uint8ClampedArray(data.data);
    console.log('image chunk')
    buf.set(imgdata, count);
    chunks[count] = data.data;
    count += imgdata.byteLength;
    if (count === buf.byteLength) {
      // we're done: all data chunks have been received
      //renderPhoto(buf);
      var builder = new Blob(chunks, buf.type);
      console.log('full image received');
      screenViewer.src = URL.createObjectURL(builder);
    }