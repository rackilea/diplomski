@Aspect
@Component
public class TimedAspect {

    private MetricRegistry registry;

    @Autowired
    public TimedAspect(MetricRegistry registry) {
        this.registry = registry;
    }

    @Around("@annotation(annotation) || @within(annotation)")
    public Object generateMetric(
            final ProceedingJoinPoint pointcut,
            final Timed annotation) throws Throwable {
        Timed anno = getAnnotation(pointcut, annotation);
        String metricName = ...;
        final Timer timer = registry.timer(metricName);
        final Timer.Context context = timer.time();

        try {
            return pointcut.proceed();
        } finally {
            context.stop();
        }
    }

    ...

}