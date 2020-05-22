@Override
public boolean equals(Object o) {
    if (o instanceof ReportItem) {
        ReportItem ri = (ReportItem) o;
        if (this.getDate().equals(ri.getDate()) && ... // compare other attributes) {
            return true;
        }
    }
    return false;
}