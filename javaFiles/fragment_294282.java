@Override
public boolean match(Context anotherContext) {
    return match(this.getUser(), anotherContext.getUser()) &&
            match(this.getApplication(), anotherContext.getApplication()) &&
            match(this.getService(), anotherContext.getService()) &&
            match(this.getOperation(), anotherContext.getOperation());
}

private boolean match(String thisString, String thatString) {
    return thisString.equals(WILDCARD) || thisString.equals(thatString);
}