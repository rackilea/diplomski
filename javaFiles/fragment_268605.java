class Response {
    private Info info;
    private String[][] schedule;
public Info getInfo() {
    return info;
}

public void setInfo(Info info) {
    this.info = info;
}

public String[][] getSchedule() {
    return schedule;
}

public void setSchedule(String[][] schedule) {
    this.schedule = schedule;
}

@Override
public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Response [info=");
    builder.append(info).append(", schedule=");
    for (String[] array : schedule) {
        builder.append(Arrays.toString(array));
    }
    builder.append("]");
    return builder.toString();
}