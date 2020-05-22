@Override
public Value getValue(Session session) {
    long lv = sequence.getNext(session);
    ValueDecimal value = ValueDecimal.get(BigDecimal.valueOf(lv)); 
    session.setLastIdentity(value);
    return value;
}

@Override
public int getType() {
    return Value.DECIMAL;
}