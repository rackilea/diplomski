else if ( AvailableSettings.NAMING_STRATEGY.equals( keyString ) ) {
    namingStrategy = strategySelector.resolveStrategy( NamingStrategy.class, entry.getValue() );
}
else if ( AvailableSettings.NAMING_STRATEGY_DELEGATOR.equals( keyString ) ) {
    namingStrategyDelegator = strategySelector.resolveStrategy( NamingStrategyDelegator.class, entry.getValue() );
}