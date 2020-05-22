DataSet<MailEntry> filteredUserReplyMails = replyMails.filter(entryTuple -> {
            String sender = entryTuple.getField(1).toString();
            return !sender.contains("git@") && !sender.contains("jira@");
        }).map(entry -> {
            MailEntry mailEntry = new MailEntry();
            mailEntry.messageId = entry.f0.replaceAll("<", "").replaceAll(">", "");
            mailEntry.sender = entry.f1;
            mailEntry.replyTo = entry.f2;
            return mailEntry;
        }).returns(MailEntry.class);