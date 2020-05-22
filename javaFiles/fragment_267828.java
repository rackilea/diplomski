public class NoRoutinesOracleDatabase extends OracleDatabase {
    @Override
    protected List<RoutineDefinition> getRoutines0() {
        return new ArrayList<>();
    }

    // other things you want to prevent...
}