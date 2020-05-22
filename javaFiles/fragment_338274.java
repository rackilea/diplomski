List<String> teamMembers = group.getTeamMemberIds() // I assume String here...
                      .stream()
                      .map(userMap::get)
                      .filter(Objects::notNull)
                      .collect(Collectors.toList());


groupDTO.getTeamMembers().addAll(teamMembers);