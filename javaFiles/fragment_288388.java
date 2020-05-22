public class MyFtpPatterFileListFilter extends AbstractFileListFilter<FTPFile> {

    private final AntPathMatcher matcher = new AntPathMatcher();

    private volatile String pattern;

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    protected boolean accept(FTPFile file) {
        return !StringUtils.hasText(this.pattern) || this.matcher.match(this.pattern, this.getFilename(file));
    }

    private String getFilename(FTPFile file) {
        return (file != null) ? file.getName() : null;
    }

}