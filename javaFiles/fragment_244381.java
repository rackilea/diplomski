new FeedbackMessagesModel(this) {    
            @Override
            protected List<FeedbackMessage> collectMessages(Component panel, IFeedbackMessageFilter filter) {
                return new FeedbackCollector(YourComponent.this.getParent()) {
                    @Override
                    protected boolean shouldRecurseInto(Component component) {
                        return true; // your citeria here
                    }
                }.setIncludeSession(false).collect(filter);
            }
        };