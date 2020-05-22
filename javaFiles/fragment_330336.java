mediaPlayerComponent = new EmbeddedMediaPlayerComponent() {
        @Override
        protected FullScreenStrategy onGetFullScreenStrategy() {
            return new Win32FullScreenStrategy(frame);
        }
    };