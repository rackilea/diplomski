public abstract class AbsractProcessor {

    public void find(Pattern pattern, String line) {
        Matcher matcher = p.matcher(line);
        if (matcher.find()) {
            process(line.substring(matcher.start() + getStartOffset(), matcher.end() - getEndOffset()));
        }
    }

    protected abstract int getStartOffset();

    protected abstract int getEndOffset();

    protected abstract void process(String str);

}