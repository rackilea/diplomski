@Transactional
public void decrementBalance(Member member) {
    MemberBalance memberBalance = entityManager.find(
        MemberBalance.class, member.id, LockModeType.PESSIMISTIC_WRITE,             
        Collections.singletonMap( "javax.persistence.lock.timeout", 200 ) //If not supported, the Hibernate dialect ignores this query hint.
    );
    if (memberBalance.getTokens() >= 1) {
        memberBalance.setTokens(memberBalance.getTokens() - 1);
        this.save(memberBalance);
    } else {
        throw new SomeCustomRTException("No balance");
    }
}