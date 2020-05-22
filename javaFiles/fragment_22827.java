function gotFileWriter(writer)
{
  var bigString = '';
  for (var i=0; i<numberOfLines; i++)
  {
    bigString += line[i];
    bigString += '\r\n';
  }
...