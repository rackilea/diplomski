PUT testindex4/_mapping
{
  "properties": {
    "device": {
      "properties": {
        "make": {
           "type": "text"
        },
        "model":{
           "type": "keyword"
        }
      }
    },
    "date": {
      "type": "date",
      "format": "yyyy-MM-dd HH:mm:ss"
    }
  }
}