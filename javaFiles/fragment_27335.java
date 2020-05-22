MyStateManager manager = new MyStateManager(channel);
// Scheduled a timer task for 40ms from now to invoke the callback
// method of your ReadTimedOutCallback and send a message through the manager
myTimer.schedule(new ReadTimedOutCallback(manager),40);
// Send an outbound request to server 2 through a class that queues
// and manages such requests asynchronously.  When the request is complete
// it invokes the callback method of RequestCompletedCallback which then
// sends a response through the manager.
myAsyncOutboundServerRequester.request(new RequestCompletedCallback(manager));
// ... finish and return the thread to Netty for use with other requests
// while the async tasks process