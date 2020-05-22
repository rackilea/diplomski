private static boolean isAdmin(Member member) {
    return member.getRoles().stream()
        .mapToLong(Role::getIdLong) // we check by id
        .anyMatch(id -> id == 628650613152153640L); // true if any role has that id
}

@Override
public void onUserUpdateOnlineStatus(UserUpdateOnlineStatusEvent event) {
        OnlineStatus os = event.getGuild().getMember(event.getUser()).getOnlineStatus();

        if (isAdmin(event.getMember())) {
            // code
        }
// the else here is unnecessary
}