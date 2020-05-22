enum WidgetFactoryImpl implements WidgetFactory {
    SMALL {
        @Override
        public Widget get() {
            return new SmallWidget();
        }
    },
    LARGE {
        @Override
        public Widget get() {
            return new LargeWidget();
        }
    };

}