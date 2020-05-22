public enum EBy {
    All, Users, Guests
}
public enum EStatus {
    All, Approved, Rejected
}
public enum EPrivacy {
    All, Public, Private
}
EBy eBy = EBy.valueOf(by);
EStatus eStatus = EStatus.valueOf(status);
EPrivacy ePrivacy = EPrivacy.valueOf(privacy);