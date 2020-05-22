@Configuration
@EnableStateMachine
public class StateMachineConfiguration {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public StateMachine<States, Events> stateMachine(StateMachineListener<States, Events> listener) throws Exception {
        StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();

        builder.configureStates()
            .withStates()
            .initial(States.LOCKED)
            .states(EnumSet.allOf(States.class));

        builder.configureTransitions()
            .withExternal()
            .source(States.LOCKED)
            .target(States.UNLOCKED)
            .event(Events.COIN)
            .and()
            .withExternal()
            .source(States.UNLOCKED)
            .target(States.LOCKED)
            .event(Events.PUSH);

        StateMachine<States, Events> stateMachine = builder.build();
        stateMachine.addStateListener(listener);
        return stateMachine;
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                logger.info("State change to " + to.getId());
            }
        };
    }
}