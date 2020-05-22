public ChannelGroupFuture write(Object message) {
         Map<Integer, ChannelFuture> futures =
             new LinkedHashMap<Integer, ChannelFuture>(size());
         if (message instanceof ChannelBuffer) {
             ChannelBuffer buf = (ChannelBuffer) message;
             for (Channel c: nonServerChannels.values()) {
                 futures.put(c.getId(), c.write(buf.duplicate()));
             }
         } else {
             for (Channel c: nonServerChannels.values()) {
                 futures.put(c.getId(), c.write(message));
             }
         }
         return new DefaultChannelGroupFuture(this, futures);
     }