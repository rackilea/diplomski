@Component
@PropertySource("file:/tmp/init.txt")
class CronSchedule {

    private static final Logger log = LoggerFactory.getLogger(CronSchedule.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRateString = "${fixrate}")
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}