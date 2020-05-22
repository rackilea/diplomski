public class Member {
    //..

    @Override
    public boolean equals(Object anObject) {
        if (!(anObject instanceof Member)) {
            return false;
        }
        Member otherMember = (Member)anObject;
        return otherMember.getUserUID().equals(getUserUID());
    }
}