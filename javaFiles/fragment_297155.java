// Use annotations to mark that this method doesn't accept null
// Check for a possible null value

@NotNull
public List<Member> getMember() {
    return Collections.unmodifiableList(member);
}

public void setMember(@NotNull final List<Member> member) {
    this.member = member != null 
           ? new ArrayList(member)
           : Collections.emptyList();
}