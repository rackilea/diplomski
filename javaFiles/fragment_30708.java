PUT testindex4/_mapping
{
  "properties": {
    "name":{
      "type":"text"
    }, 
    "date":
    {
      "type":"date",
      "format":"YYYY-MM-DD'T'HH:mm:ss"
    }
  }
}