@Bean
public Trigger onlyOnceTrigger() {
       return new Trigger() {
              private final AtomicBoolean invoked = new AtomicBoolean();
              @Override
              public Date nextExecutionTime(TriggerContext triggerContext) {
                    return this.invoked.getAndSet(true) ? null : new Date();
              }
       };
}