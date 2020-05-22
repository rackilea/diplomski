mediaPlayerComponent = new EmbeddedMediaPlayerComponent() {
        @Override
        protected FullScreenStrategy onGetFullScreenStrategy() {
            if (RuntimeUtil.isWindows()) {
                return new Win32FullScreenStrategy(frame);
            }
            else {
                return new XFullScreenStrategy(frame);
            }
        }
    };