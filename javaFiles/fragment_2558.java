package xyz;
import com.sun.source.util.TaskEvent;
import com.sun.source.util.TaskListener;

import java.util.HashMap;

public class FileTimestampListener implements TaskListener {
    HashMap<String, Long> timeStampMap = new HashMap<>();

    @Override
    public void started(TaskEvent taskEvent) {
        if(TaskEvent.Kind.GENERATE.equals(taskEvent.getKind())) {
            String name = taskEvent.getSourceFile().getName();
            timeStampMap.put(name, System.currentTimeMillis());
        }
    }

    @Override
    public void finished(TaskEvent taskEvent) {
        if(TaskEvent.Kind.GENERATE.equals(taskEvent.getKind())) {
            String name = taskEvent.getSourceFile().getName();
            System.out.println("Generated " + name + " over " + (System.currentTimeMillis() - timeStampMap.get(name)) + " milliseconds");
        }
    }
}