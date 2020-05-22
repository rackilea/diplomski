class Base {
    public String serializeToString() {
        StringBuilder sb = new StringBuilder();
        appendSerializedTo(sb);
        return sb.toString();
    }

    // can be abstract if there's no implementation here
    protected void appendSerializedTo(StringBuilder sb) {
        sb.append("baseAttribute: 3");
    }
}

class SecondLevel {
    @Override protected void appendSerializedTo(StringBuilder sb) {
        super.appendSerializedTo(sb); // calls Base implementation
        sb.append("secondLevelAttribute: 2");
    }
}

// and so on...