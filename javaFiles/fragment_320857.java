@Override
public Value getValue(Session session) {
    long value = sequence.getNext(session);
    session.setLastIdentity(ValueLong.get(value));
    return ValueLong.get(value);
}

@Override
public int getType() {
    return Value.LONG;
}