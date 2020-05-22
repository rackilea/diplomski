PUT my_index
{
  "mappings": {
    "properties": {
      "datetime": {
        "type":   "date",
        "format": "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd'T'HH:mm:ss.SSSZ||epoch_millis"
      }
    }
  }
}