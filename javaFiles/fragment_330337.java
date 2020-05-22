mediaPlayerComponent = new EmbeddedMediaPlayerComponent() {
        @Override
        protected FullScreenStrategy onGetFullScreenStrategy() {
            return new XFullScreenStrategy(frame);
        }
    };