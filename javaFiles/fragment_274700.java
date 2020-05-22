private static final IFeedbackMessageFilter renderedMessagesForComponents =
    new IFeedbackMessageFilter()
    {
        @Override
        public boolean accept(FeedbackMessage message)
        {
            return message.getReporter() != null && message.isRendered();
        }
    };

@Override
protected void cleanupComponentFeedbackMessages()
{
    // deliberately not calling the method in the superclass because it
    // clears all messages for components.
    getFeedbackMessages().clear(renderedMessagesForComponents);
}