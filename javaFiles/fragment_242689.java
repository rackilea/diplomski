for(final String mob: mobNames) {
    mobs.addPlotter(new Metrics.Plotter(mob) {

        @Override
            public int getValue() {
                return Stats.getValue(mob);
            }

    });
}