@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<MachineState, MachineEvent> {


    @Override
    public void configure(final StateMachineConfigurationConfigurer<MachineState, MachineEvent> config)
            throws Exception {
        config
            .withConfiguration()
            .autoStartup(true);
    }

    @Override
    public void configure(final StateMachineStateConfigurer<MachineState, MachineEvent> states)
            throws Exception {
        states
            .withStates()
                .initial(MachineState.INITIAL)
                .state(MachineState.INITIAL, init(), null)
                .state(MachineState.PARENT)
                .and()

                // Region 1 (BUFF)
                .withStates()
                    .parent(MachineState.PARENT)
                    .initial(MachineState.BUFF)
                    .and()
                    .withStates()
                        .parent(MachineState.BUFF)
                        .initial(MachineState.BUFF_OFFLINE)
                        .state(MachineState.BUFF_ONLINE)
                .and()

                // Region 2 (CB)
                .withStates()
                    .parent(MachineState.PARENT)
                    .initial(MachineState.CB)
                    .and()
                    .withStates()
                        .parent(MachineState.CB)
                        .initial(MachineState.CB_OFFLINE)
                        .state(MachineState.CB_ONLINE)
                .and()
        ;
    }

    @Override
    public void configure(final StateMachineTransitionConfigurer<MachineState, MachineEvent> transitions)
            throws Exception {
        transitions
            .withExternal()
                .source(MachineState.BUFF_OFFLINE).target(MachineState.BUFF_ONLINE)
                .event(MachineEvent.BUFF_ON)
            .and()

            .withExternal()
                .source(MachineState.BUFF_ONLINE).target(MachineState.BUFF_OFFLINE)
                .event(MachineEvent.BUFF_OFF)
            .and()

            .withExternal()
                .source(MachineState.CB_OFFLINE).target(MachineState.CB_ONLINE)
                .event(MachineEvent.CB_ON)
            .and()

            .withExternal()
                .source(MachineState.CB_ONLINE).target(MachineState.CB_OFFLINE)
                .event(MachineEvent.CB_OFF)
            .and()

            .withInternal()
                .source(MachineState.CB)
                .event(MachineEvent.CB_NORESP)
            .and()

            .withInternal()
                .source(MachineState.BUFF)
                .event(MachineEvent.BUFF_NORESP)
            .and()

            .withExternal()
                .source(MachineState.INITIAL).target(MachineState.PARENT)
                .event(MachineEvent.INIT)
            .and()
        ;
    }

    @Bean
    public Action<MachineState, MachineEvent> init() {
        return new Action<MachineState, MachineEvent>() {
            @Override
            public void execute(StateContext<MachineState, MachineEvent> context) {
                context.getStateMachine().sendEvent(MachineEvent.INIT);
            }
        };
    }
}