HttpEntity messageEntity = httpResponse.getEntity();

if (messageEntity != null) {
    MessagePack msgpack = new MessagePack();

    MessageUnpacker u = msgpack.newUnpacker(messageEntity.getContent());
    MapValue mv = (MapValue) u.unpackValue();

    Map<Value, Value> map = mv.map();