public class MyStoryReporter implements org.jbehave.core.reporters.StoryReporter{
     private Log log = ...

     @Override
     public void successful(String step) {
        log.info(">>successStep:" + step);
     }

    @Override
    public void failed(String step, Throwable cause) {
        log.error(">>error:" + step + ", reason:" + cause);
    }

     ...
 }