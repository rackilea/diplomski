eventBus.addBeanCreatedEventHandler(RcTaskSchedule.class, NavigationTarget.RC_TASK_SCHEDULE_DIALOG, new BeanCreatedEvent.Handler<RcTaskSchedule>() {
    @Override
    public void onBeanCreated(BeanCreatedEvent<RcTaskSchedule> event) {
        ListBinding.addListItemInBeanModel(display.getBeanModel(), "schedules", schedulesFactory.createModel(event.getBean()));
    }
});

eventBus.addBeanModifiedEventHandler(RcTaskSchedule.class, NavigationTarget.RC_TASK_SCHEDULE_DIALOG, new BeanModifiedEvent.Handler<RcTaskSchedule>() {
    @Override
    public void onBeanModified(BeanModifiedEvent<RcTaskSchedule> event) {
        ListBinding.updateListItemInBeanModel(display.getBeanModel(), "schedules",
                schedulesFactory.createModel(event.getOldBean()), schedulesFactory.createModel(event.getModifiedBean()));
    }
});