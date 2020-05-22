Configuration:
  status: debug

  Appenders:
    RandomAccessFile:
      - name: APPLICATION_APPENDER
        fileName: logs/application.log
        PatternLayout:
          Pattern: "%d{ISO8601_BASIC} %-5level %msg%n"
      - name: FATAL_APPENDER
        fileName: logs/application.log
        PatternLayout:
          Pattern: "%d{ISO8601_BASIC} FATAL %msg%n"

    Routing:
      name: ROUTING_APPENDER
      Routes:
        pattern: "$${marker:}"
        Route:
        - key: FATAL
          ref: FATAL_APPENDER
        - ref: APPLICATION_APPENDER #DefaultRoute

  Loggers:
    Root:
      level: trace
      AppenderRef:
        - ref: ROUTING_APPENDER