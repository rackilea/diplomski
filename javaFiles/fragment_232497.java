List<GroupMember> newList = groups.get(request.getGroup()).stream().map(
      member -> {
           int updatedMemberIndex = request.getGroupMembers().indexOf(member);
           return updatedMemberIndex != -1
               ? request.getGroupMembers().get(updatedMemberIndex)
               : member;
      }
).collect(Collectors.toList());