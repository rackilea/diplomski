public MqttWireMessage(byte type) {
        this.type = type;
        // Use zero as the default message ID.  Can't use -1, as that is serialized
        // as 65535, which would be a valid ID.
        this.msgId = 0;
    }