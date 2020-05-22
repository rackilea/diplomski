private static void initialize() {
    if ((strategyName == null) || "".equals(strategyName)) {
        // Set default
        strategyName = MODE_THREADLOCAL;
    }

    if (strategyName.equals(MODE_THREADLOCAL)) {
        strategy = new ThreadLocalSecurityContextHolderStrategy();
    } else if (strategyName.equals(MODE_INHERITABLETHREADLOCAL)) {
        strategy = new InheritableThreadLocalSecurityContextHolderStrategy();
    } else if (strategyName.equals(MODE_GLOBAL)) {
        strategy = new GlobalSecurityContextHolderStrategy();
    } else {
        // Try to load a custom strategy
        try {
            Class<?> clazz = Class.forName(strategyName);
            Constructor<?> customStrategy = clazz.getConstructor();
            strategy = (SecurityContextHolderStrategy) customStrategy.newInstance();
        } catch (Exception ex) {
            ReflectionUtils.handleReflectionException(ex);
        }
    }

    initializeCount++;
}