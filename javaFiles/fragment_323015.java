Stream<List<MediaFeedData>> stream = StreamSupport.stream(
    new Spliterators.AbstractSpliterator<List<MediaFeedData>>(Long.MAX_VALUE, 0) {
        long lastTime=System.currentTimeMillis();
        @Override
        public boolean tryAdvance(Consumer<? super List<MediaFeedData>> action) {
            if(quitCondition()) return false;
            List<MediaFeedData> feedDataList = null;
            while (feedDataList == null) {
                lastTime+=TimeUnit.SECONDS.toMillis(2);
                while(System.currentTimeMillis()<lastTime)
                    LockSupport.parkUntil(lastTime);
                try {
                    feedDataList=newData();
                } catch (InstagramException e) {
                    notifyError(e.getMessage());
                    if(QUIT_ON_EXCEPTION) return false;
                }
            }
            action.accept(feedDataList);
            return true;
        }
    }, false);