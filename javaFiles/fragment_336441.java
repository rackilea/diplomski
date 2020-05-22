@NoAutoStart
public class CustomTriggerPolicy<E> extends SizeAndTimeBasedFNATP<E> {
    @Override
    public boolean isTriggeringEvent(File activeFile, E event) {
        boolean triggeringEvent = super.isTriggeringEvent(activeFile, event);
        if(!triggeringEvent) {
            elapsedPeriodsFileName = getCurrentPeriodsFileNameWithoutCompressionSuffix();
        }
        return triggeringEvent;
    }
}