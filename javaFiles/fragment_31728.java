final ArrayList<Predicate> predicates = new ArrayList<Predicate>();
if(accountID != null) 
    predicates.add(cb.equal(acc.get("accountID"), accountID));
}
if(userId != null) {
    predicates.add(cb.equal(acc.get("userId"), userId));
}

switch(predicates.size()){
case 0:
    return null;
    //or maybe just continue to return all accounts...
case 1:
    cq.where(predicates.get(0));
    break;
default:
    cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
}