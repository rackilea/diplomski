interface Event {
    public void onEvent(Context context);
}

class DocumentEvent implements Event {
    public void onEvent(Context context) {
         context.getDocumentGenerator().gerenateDocument(this);
    }
}

class MailEvent implements Event {
    public void onEvent(Context context) {
         context.getDeliveryManager().deliverMail(event);
    }
}


class Context {
    public void divideEvent(Event event) {
        event.onEvent(this);
    }
}