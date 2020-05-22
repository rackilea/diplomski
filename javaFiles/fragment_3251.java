function onSuccess(imageURI) {
  img_uri = imageURI;
  alert(img_uri);
  window.resolveLocalFileSystemURI(img_uri, function(fileEntry) {
      alert(fileEntry.fullPath);
      Plugin.callNativeFunction(nativePluginResultHandler, nativePluginErrorHandler, 'success', fileEntry.fullPath);
  }, onError);      
}