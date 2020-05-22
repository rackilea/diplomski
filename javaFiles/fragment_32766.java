public class DelayedElement implements Comparable<DelayedElement> {

private final Long initTime;
private final String msgId;

public DelayedElement(Long initTime, String msgId) {
    this.initTime = initTime;
    this.msgId = msgId;
}             

@Override
public int hashCode() {
    int hash = 5;
    hash = 29 * hash + Objects.hashCode(this.initTime);
    hash = 29 * hash + Objects.hashCode(this.msgId);
    return hash;
}

@Override
public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final DelayedElement other = (DelayedElement) obj;
    if (!Objects.equals(this.initTime, other.initTime)) {
        return false;
    }
    if (!Objects.equals(this.msgId, other.msgId)) {
        return false;
    }
    return true;
}
@Override
public int compareTo(DelayedElement o) {
    return -o.initTime.compareTo(initTime);
    }
}