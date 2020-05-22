public MessageFragement(String id, String markupId, MarkupContainer markupProvider, final Message message) {
            super(id, markupId, markupProvider, new Model<Message>(message));

            setRenderBodyOnly(true);
...
}