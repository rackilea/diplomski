//Song
@Override
public String toString() {
    CustomToStringBuilder builder = new CustomToStringBuilder(this);
    builder.appendItem("title", title).appendItem("lengthInSeconds", lengthInSeconds);
    return builder.getString();
}

//Album
@Override
public String toString() {
    CustomToStringBuilder builder = new CustomToStringBuilder(this);
    builder.appendItem("songs", songs).appendItem("songCount", songCount);
    return builder.getString();
}