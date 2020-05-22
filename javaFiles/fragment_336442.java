import ch.qos.logback.core.rolling.RolloverFailure;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import ch.qos.logback.core.rolling.helper.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Custom rolling policy where we trigger rollback at shutdown.
 */
public class MktDataRollingPolicy<E> extends TimeBasedRollingPolicy<E> {

    private static final String LOGBACK_STATUS_FILE_NAME = "logback-status.log";
    private Compressor compressor;
    private RenameUtil renameUtil = new RenameUtil();
    private String basePath;
    private String logbackStatusFilePath;

    FileNamePattern zipEntryFileNamePattern;

    @Override
    public void start() {
        basePath = System.getProperty("logback.statusLog", "/home/master/logs/mkt-data-log");
        logbackStatusFilePath = basePath + File.separator + LOGBACK_STATUS_FILE_NAME;
        super.start();
        // set the LR for our utility object
        renameUtil.setContext(this.context);

        compressor = new Compressor(compressionMode);
        compressor.setContext(context);

        if (compressionMode == CompressionMode.ZIP) {
            String zipEntryFileNamePatternStr = transformFileNamePattern2ZipEntry(fileNamePatternStr);
            zipEntryFileNamePattern = new FileNamePattern(zipEntryFileNamePatternStr, context);
        }
        Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHookRunnable()));
    }

    @Override
    public void rollover() throws RolloverFailure {
        String elapsedPeriodsFileName = getTimeBasedFileNamingAndTriggeringPolicy().getElapsedPeriodsFileName();
        if (elapsedPeriodsFileName != null) {
            if (compressionMode == CompressionMode.NONE) {
                if (getParentsRawFileProperty() != null) {
                    renameUtil.rename(getParentsRawFileProperty(), elapsedPeriodsFileName);
                } // else { nothing to do if CompressionMode == NONE and parentsRawFileProperty == null }
            } else {
                String elapsedPeriodStem = FileFilterUtil.afterLastSlash(elapsedPeriodsFileName);
                if (getParentsRawFileProperty() == null) {
                    compressor.compress(elapsedPeriodsFileName, elapsedPeriodsFileName, elapsedPeriodStem);
                } else {
                    if (isLogFileEmpty()) {
                        addInfo("Skipping compression for empty file: " + getParentsRawFileProperty());
                        return;
                    }
                    renameRawAndCompress(elapsedPeriodsFileName, elapsedPeriodStem);
                }
            }
        } else {
            String msg = String.format("ElapsedPeriodsFileName is null. Skipping rollover for file: %s",
                    getParentsRawFileProperty());
            addWarn(msg);
            File statusFile = new File(logbackStatusFilePath);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(statusFile, true))) {
                bw.append(msg);
                bw.append("\n");
            } catch (IOException e) {
                System.out.println("Failed to write to status file: " + logbackStatusFilePath);
                e.printStackTrace();
            }
        }
    }


    private boolean isLogFileEmpty() {
        File f = new File(getParentsRawFileProperty());
        return f.exists() && f.length() == 0;
    }

    private String transformFileNamePattern2ZipEntry(String fileNamePatternStr) {
        String slashified = FileFilterUtil.slashify(fileNamePatternStr);
        return FileFilterUtil.afterLastSlash(slashified);
    }

    void renameRawAndCompress(String nameOfCompressedFile, String innerEntryName) throws RolloverFailure {
        String parentsRawFile = getParentsRawFileProperty();
        String tmpTarget = nameOfCompressedFile + System.nanoTime() + ".tmp";
        renameUtil.rename(parentsRawFile, tmpTarget);
        compressor.compress(tmpTarget, nameOfCompressedFile, innerEntryName);
    }

    class ShutdownHookRunnable implements Runnable {
        @Override
        public void run() {
            try {
                addInfo("Calling rollover inside shutdown hook");
                rollover();
            } catch (Exception e) {
                addError("Failed to rollover", e);
            }
        }
    }
}