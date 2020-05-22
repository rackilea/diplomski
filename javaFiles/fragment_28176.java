public abstract class KeysForDataSpecific23 extends Data {
    protected KeysForDataSpecific23() {
        identifiers.put("key", By.cssSelector("something"));
    }
}

public class DataSpecific2 extends KeysForDataSpecific23 {
}


public class DataSpecific3 extends KeysForDataSpecific23 {
}