public class JodaDateTimeConsumeAll implements DateTimeParser{

    @Override
    public int estimateParsedLength() {
        return 100;
    }

    @Override
    public int parseInto(DateTimeParserBucket bucket, String text, int position) {
        return text.length(); //consume the whole thing
    }

}