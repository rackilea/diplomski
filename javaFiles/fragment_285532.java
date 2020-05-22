if (eventDBLoggingEnabled) {
                long eventId = 0L;
                try {
                    logger.info("Saving event data in DB now........");
                    eventId = logEventData(route.getRouteId(), message, transformedMessage, incomingEventTimestamp,
                            outgoingEventTimestamp, DEFAULT_USER_ID);
                } catch (Exception e) {
                    logger.error("Some error occured while storing data in event log tables for eventId: "
                            + eventId + " - " + e.getMessage(), e);
                    errorAlertService.sendAlert(e, route, message, Alert.AlertType.ERROR_500);
                }
            }
        }
        return MessageHandler.Status.OK;
    }

    private long logEventData(int routeId, String incomingEventMessage, String outgoingEventMessage,
            Timestamp incomingEventTimestamp, Timestamp outgoingEventTimestamp, String userId)
            throws SQLException, Exception {
        long eventId = 0L;
        Future<Long> future = eventLogService.saveEventData(routeId, incomingEventMessage, outgoingEventMessage,
                incomingEventTimestamp, outgoingEventTimestamp, userId);
        while (true) {
            if (future.isDone()) {
                eventId = future.get();
                break;
            }
        }
        return eventId;
    }