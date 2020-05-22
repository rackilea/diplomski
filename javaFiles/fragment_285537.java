Session s = Session.getDefaultInstance(new Properties());
    InputStream is = new ByteArrayInputStream(a_sHeader.getBytes());
    try {
        m_message = new MimeMessage(s, is);

        m_message.getAllHeaderLines();
        for (Enumeration<Header> e = m_message.getAllHeaders(); e.hasMoreElements();) {
            Header h = e.nextElement();
            // Recipients
            if (h.getName().equalsIgnoreCase(getHeaderName(RecipientType.REC_TYPE_TO))) {
                m_RecipientsTo = processAddresses(h.getValue());
            }
            ...             
        }
    } catch (MessagingException e1) {
        ...             
    }