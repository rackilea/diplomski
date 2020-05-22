private Invocation.Builder prepareHandshakeRequest() {
            Invocation.Builder request = EventSource.this.target
                    .request(new MediaType[] { SseFeature.SERVER_SENT_EVENTS_TYPE });
            if ((this.lastEventId != null) && (!(this.lastEventId.isEmpty()))) {
                request.header("Last-Event-ID", this.lastEventId);
            }
            if (EventSource.this.disableKeepAlive) {
                request.header("Connection", "close");
            }
            return request;
          }