import org.apache.tika.Tika;

try {
    return new Tika().detect(new File(basePath + "/" + fileName));
} catch (final Exception exception) {
    return "<EXCEPTION: " + exception.getMessage() + ">";
}