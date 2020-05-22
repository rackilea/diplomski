package xyz;
import com.sun.source.util.JavacTask;
import com.sun.source.util.Plugin;

public class TimestampPlugin implements Plugin {


    @Override
    public String getName() {
        return "Timestamp_Plugin";
    }

    @Override
    public void init(JavacTask task, String... strings) {
        task.setTaskListener(new FileTimestampListener());
    }
}