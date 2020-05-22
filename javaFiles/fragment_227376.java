@Bean
ApplicationListener<BeforeSaveEvent> beforeSaveEventApplicationListener() {
    return new ApplicationListener<BeforeSaveEvent>() {
        @Override
        public void onApplicationEvent(BeforeSaveEvent event) {
               event.getEntity().setCreatedDate(System.currentTimeMillis());
        }
    };
}