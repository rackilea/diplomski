/**
* Register to handle to incoming messages in this conversation. A maximum of one message handler per
* native websocket message type (text, binary, pong) may be added to each Session. I.e. a maximum
* of one message handler to handle incoming text messages a maximum of one message handler for
* handling incoming binary messages, and a maximum of one for handling incoming pong
* messages. For further details of which message handlers handle which of the native websocket
* message types please see {@link MessageHandler.Whole} and {@link MessageHandler.Partial}.
* Adding more than one of any one type will result in a runtime exception.
*
* @param clazz   type of the message processed by message handler to be registered.
* @param handler whole message handler to be added.
* @throws IllegalStateException if there is already a MessageHandler registered for the same native
*                               websocket message type as this handler.
*/
public void addMessageHandler(Class<T> clazz, MessageHandler.Whole<T> handler);