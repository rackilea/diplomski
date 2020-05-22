return flow -> flow.channel(bucketNotificationChannel())
            .handle(handler)
            .log(INFO, "Handler finished", m -> {
                return "got" + m;
            })
            .log(DEBUG, "acknowledgementFlow", m -> "Handling acknowledgement for message: " + m)
            .handle(pubSubAckHandler);