{
    "Configuration": {
        "Appenders": {
            "appender": [
                {
                    "type": "Console",
                    "PatternLayout": {
                        "pattern": "%d{yyyy-MMM-dd HH:mm:ss a} [%t] %-5level %logger{36} - %msg%n"
                    },
                    "name": "Console",
                    "target": "SYSTEM_OUT"
                },
                {
                    "type": "RollingFile",
                    "name": "general",
                    "fileName": "C:/logs/simulator-log.log",
                    "filePattern": "C:/logs/simulator-log-%d{yyyy-MM-dd HH-mm-ss}.log",
                    "PatternLayout": {
                        "pattern": "%msg%n"
                    },
                    "Policies": {
                        "OnStartupTriggeringPolicy": {

                        }
                    }
                },
                {
                    "type": "File",
                    "PatternLayout": {
                        "pattern": "%msg%n"
                    },
                    "name": "test",
                    "fileName": "c:/logs/requests_received.log"
                },
                {
                    "type": "File",
                    "PatternLayout": {
                        "pattern": "%msg%n"
                    },
                    "name": "test1",
                    "fileName": "c:/logs/response_sent.log"
                }
            ]
        },
        "Loggers": {
            "Root": {
                "AppenderRef": [
                    {
                        "ref": "Console"
                    }
                ],
                "level": "trace"
            },
            "logger": [
                {
                    "name": "test",
                    "level": "trace",
                    "additivity": "false",
                    "AppenderRef": {
                        "ref": "test"
                    }
                },
                {
                    "name": "test1",
                    "level": "trace",
                    "additivity": "false",
                    "AppenderRef": {
                        "ref": "test1"
                    }
                },
                {
                    "name": "general",
                    "level": "trace",
                    "additivity": "false",
                    "AppenderRef": {
                        "ref": "general"
                    }
                }
            ]
        }
    }
}