class DatePredicate implements Predicate<BirthId, Birth> {

BirthId birthIdToCompare;

public DatePredicate() {
}

public DatePredicate(BirthId birthId) {
    this.birthIdToCompare = birthId;
}

@Override
public boolean apply(Map.Entry<BirthId, Birth> mapEntry) {
    BirthId key = mapEntry.getKey();
    ///your custom logic
    return true;
}
}