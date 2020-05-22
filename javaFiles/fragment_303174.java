public enum LogLevel {
    NOLOG("6") , ERROR("5"), WARN("4"), INFO("3"), DEBUG("2"), TRACE("1") ;

    private Integer value;

    LogLevel(Integer value) {
        this.value = value;
    }

    public static LogLevel levelOf(Integer value) {
        for (LogLevel level : LogLevel.values()) {
            if (level.value.equals(value)) {
                return level;
            }
        }
        return null;
    }
}