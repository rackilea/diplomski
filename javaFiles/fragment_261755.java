private boolean handleStartAction(Intent intent) {
    if (intent == null) {
      Log.e("NULL INTENT", "***************NULL INTENT**************");
    } else {
      String action = intent.getAction();

      if (action == null) {
        return false;
      }

      if (action.equalsIgnoreCase(MQTTConstants.MQTT_SUBSCRIBE_TOPIC_INTENT)) {
        handleSubscribeTopicIntent(intent);
      }

      if (action.equalsIgnoreCase(MQTTConstants.MQTT_PUBLISH_MSG_INTENT)) {
        handlePublishMessageIntent(intent);
      }

      if (action.equalsIgnoreCase(MQTTConstants.MQTT_UNSUBSCRIBE_TOPIC_INTENT)) {
        handleUnsubscribeTopicIntent(intent);
      }
    }

    return true;
  }