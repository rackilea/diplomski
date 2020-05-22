private final int INEXISTENT_COLUMN_ERROR = ?
    private final int DUPLICATE_DATA_ERROR = ?

    private final String INEXISTENT_COLUMN_PATTERN = ?;
    private final String DUPLICATE_DATA_PATTERN = ?;

    ...

    try {
            ...
        } catch (SQLException e){
            if (e.getErrorCode() == INEXISTENT_COLUMN_ERROR)
               System.out.println("User friendly error message caused by column " + this.matchPattern(e.getMessage(), this.INEXISTENT_COLUMN_PATTERN));
            if (e.getErrorCode() == DUPLICATE_DATA_ERROR)
                System.out.println("User friendly error message caused by duplicate data " + this.matchPattern(e.getMessage(), this.DUPLICATE_DATA_PATTERN));
        }

...

private String matchPattern(final String string, final String pattern) {
    final Pattern p = Pattern.compile(pattern);
    final Matcher m = p.matcher(string);
    ...
}