long authorID = event.getMessage().getAuthor().getIdLong();
Member member = event.getGuild().getMemberById(authorID);
Role role = event.getMessage().getMentionedRoles().get(0); //checks for mentioned roles in the message

      event
            .getGuild()
            .getController()
            .addSingleRoleToMember(member, role)
            .complete();