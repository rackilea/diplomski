// Code as before...
kryo.writeObject(buffer, pojo);

// This call is all that's new
buffer.flip();

PlayerPOJO player = kryo.readObject(buffer, PlayerPOJO.class);
// Code as before...