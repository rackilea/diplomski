{
  "configuration": {
    "status": "info",
    "name": "LOGGER",
    "packages": "org.graylog2.log4j2",
    "appenders": {
      "GELF": {
        "name": "GELF",
        "server": "log.myapp.com",
        "port": "12201",
        "hostName": "my-awsome-app",
        "JSONLayout": {
          "compact": "false",
          "locationInfo": "true",
          "complete": "true",
          "eventEol": "true",
          "properties": "true",
          "propertiesAsList": "true"
        },
        "ThresholdFilter": {
          "level": "info"
        }
      }
    },
    "loggers": {
      "logger": [
        {
          "name": "io.netty",
          "level": "info",
          "additivity": "false",
          "AppenderRef": {
            "ref": "GELF"
          }
        }        
      ],
      "root": {
        "level": "info",
        "AppenderRef": [
          {
            "ref": "GELF"
          }
        ]
      }
    }
  }
}