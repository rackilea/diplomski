public Group toGroup(Team team) {
    Group result = new Group(team.teamId());
    // this is missing in your sample code
    result.setGroupMembers(transform(team.getTeamMembers());
    List<Group> subGroups = team.getTeams().stream()
        .map(this::toGroup) // recursive call to this method
        .collect(toList());
    result.setSubgroups(subGroups);
    return result;
}