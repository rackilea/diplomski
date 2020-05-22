Function<Groupable, Grouping> groupFunction = new Function<Groupable, Grouping>(){

    @Override
    public Grouping apply(Groupable groupable) {

        return groupable.getGrouping();
    }

};

ImmutableListMultimap<Grouping, Groupable> groupings = Multimaps.index(lsGroupable, groupFunction);