"loggers": {
        "logger":
        {
            "name": "fileLogger",
            "level": "info",
            "appender-ref": { "ref": "fileAppender" }
        },
        "root": {
            "level": "info",
            "appender-ref": { "ref": "consoleAppender" }
        }
    }