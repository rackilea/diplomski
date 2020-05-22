StringBuilder message = new StringBuilder();
class AppendingStringBuilder {
    private final StringBuilder builder;
    AppendingStringBuilder(StringBuilder builder) {
        this.builder = builder;
    }
    public AppendingStringBuilder append(String str) {
        builder.append(str + "\n");
        return this;
    }
}
AppendingStringBuilder messageHelper;
// ...