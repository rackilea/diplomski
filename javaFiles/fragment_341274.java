public class MaxLevelFilter implements Filter {

    private final Level maxLevel;

    public MaxLevelFilter(Level level) {
        this.maxLevel = level;
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return maxLevel.intValue() > record.getLevel().intValue();
    }

}