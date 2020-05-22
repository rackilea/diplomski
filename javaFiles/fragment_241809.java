@Override
public Account getAccountByNickName(String nickname, String accountsCollection) {
    Criteria criteria = Criteria.where("personalSettings.nickName").is(nickname);
    DBCollection coll = mongoOperation.getCollection(accountsCollection);
    DBCursor dbCursor = coll.find(Query.query(criteria).getQueryObject());
    DBObject dbobj = dbCursor.next();
    Account account = (new Gson()).fromJson(dbobj.toString(), Account.class);
    return account;
}