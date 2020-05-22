@Component
static class MyListener implements ApplicationListener<ApplicationEvent> 
    public void onApplicationEvent(ApplicationEvent event) {
         // do stuff, typically check event subclass (instanceof) to know which action to perform
    }
}