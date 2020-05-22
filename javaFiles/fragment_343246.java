Scheduler.get().scheduleFinally(new ScheduledCommand() {
        @Override
        public void execute() {
            stateResolver.resolveState(((DynamicTablePlace) pc.getWhere()).getTablehash(), eb);

        }
    });