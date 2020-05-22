Timer.Sample sample = Timer.start(registry);
    try {
        return pjp.proceed();
    } finally {
        sample.stop(Timer.builder(timed.value())
                .description(timed.description().isEmpty() ? null : timed.description())
                .tags(timed.extraTags())
                .tags(tagsBasedOnJoinpoint.apply(pjp))
                .publishPercentileHistogram(timed.histogram())
                .publishPercentiles(timed.percentiles().length == 0 ? null : timed.percentiles())
                .register(registry));
    }