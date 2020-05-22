public class FileWrapper {

    private static final String TIME_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";

    private Date timeStamp;
    public Date getTimeStamp() { return timeStamp; }

    private String fileName;
    public String getFileName() { return fileName; }

    private Long fileSize;
    public Long getFileSize() { return fileSize; }

    private FileWrapper(String timeStamp, String fileName, Long fileSize) throws ParseException {
    this.timeStamp = new SimpleDateFormat(TIME_FORMAT).parse(timeStamp);
    this.fileName = fileName;
    this.fileSize = fileSize;
    }

    public static FileWrapper from(final String timeStamp, final String fileName, final Long fileSize) {
    try {
        return new FileWrapper(timeStamp, fileName, fileSize);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return null;
    }

}