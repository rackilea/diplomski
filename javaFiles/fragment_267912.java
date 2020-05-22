{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "title": "Product",
  "type": "object",
  "properties": {
    "endpoints": {
      "type": "array",
      "items": {
        "type": "string"
      }
    },
    "poi": {
      "type": "array",
      "items": {
        "type": "object",
        "properties": {
          "location_name": {
            "type": "string"
          },
          "latitude": {
            "type": "string"
          },
          "longitude": {
            "type": "string"
          },
          "distance": {
            "type": "string"
          }
        }
      }
    }
  }
}