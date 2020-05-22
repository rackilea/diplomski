@RabbitListener(queues = "queue1")
public void handleMessage(Object o) {
    if (o instanceof Type1) {
        delegate.type1((Type1) o);
    }
    else if (o instanceof Type2) {
        delegate.type2((Type2) o);
    } 
}