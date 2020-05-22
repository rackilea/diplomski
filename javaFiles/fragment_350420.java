// Stub classes
class JsonObject { }

@FunctionalInterface
interface ReplyMessage<T> {
    void reply(T jo);
}

class LambdaDemo {
    public static void main(String args[]) {

        // Dummy variables
        ReplyMessage<JsonObject> message = new ReplyMessage<JsonObject>() {
            public void reply(JsonObject jo) {}
        };
        ReplyMessage[] paramsValues = new ReplyMessage[5];
        int idx = 0;

        // Your code, lambdafied
        paramsValues[idx++] = reply -> message.reply(reply);

        // Or,
        // paramsValues[idx++] = message::reply;

        // But then you could perhaps do with just ...
        // paramsValues[idx++] = message;
    }
}