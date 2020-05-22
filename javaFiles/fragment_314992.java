MimeMessage msg = new MimeMessage(session) {
            protected void updateMessageID() throws MessagingException {
                if (getHeader("Message-ID") == null)
                    super.updateMessageID();
            }
        };