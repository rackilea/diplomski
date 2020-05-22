public Member searchMembersByEmail(String emailEntered) {
    if (members != null) {
        for (Member m : members) {
            if (m == null) continue;

            if (emailEntered.equals(m.getEmail())) 
                return m;
        }
    }

    return null;
}