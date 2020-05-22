{
  "configuration": {
    "name": "cool_log",
    "appenders": {
      "RollingFile": {
        "name": "rollingFile",
        "fileName": "logservice.log",
        "filePattern": "%d{MM-dd-yy-HH-mm-ss}-%i.log.gz",
        "JSONLayout": {
          "complete": false,
          "compact": true,
          "eventEol": true
        },
        "SizeBasedTriggeringPolicy": {
          "size": "1 KB"
        },
        "DefaultRolloverStrategy": {
          "max": "10"
        }
      }
    },
    "loggers": {
      "root": {
        "level": "DEBUG",
        "appender-ref": {
          "ref": "rollingFile"
        }
      }
    }
  }
}