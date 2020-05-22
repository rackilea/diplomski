public class MyDatabase extends PostgresDatabase {
    @Override
    protected List<RoutineDefinition> getRoutines0() throws SQLException {
        List<RoutineDefinition> routines = super.getRoutines0();
        List<RoutineDefinition> result = new ArrayList<>(routines);

        routineLoop:
        for (RoutineDefinition routine : routines) {
            if (routine.isSQLUsable()) {
                List<ParameterDefinition> in = new ArrayList<>(routine.getInParameters());
                Iterator<ParameterDefinition> it = in.iterator();
                boolean hasDefaulted = false;

                while (it.hasNext())
                    if (it.next().isDefaulted()) {
                        hasDefaulted = true;
                        it.remove();
                    }

                    // This approach only works if the trailing params are defaulted
                    else if (hasDefaulted)
                        continue routineLoop;

                if (hasDefaulted)
                    result.add(new AbstractRoutineDefinition(
                        routine.getSchema(), null, routine.getName(), 
                        routine.getComment(), "OverloadIndex" // Replace this
                    ) {
                        @Override
                        protected void init0() {
                            addParameter(InOutDefinition.RETURN, routine.getReturnValue());

                            for (ParameterDefinition p : in)
                                addParameter(InOutDefinition.IN, p);
                        }
                    });
            }
        }

        return result;
    }
}