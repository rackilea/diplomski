...
  writer.onwrite = function (evt) { ... };
  writer.onwriteend = function (evt) { ... };
  writer.seek(writer.length);
  writer.write (bigString);
}