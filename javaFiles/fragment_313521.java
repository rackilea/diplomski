MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();  
mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");  
mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");  
mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");  
mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");  
mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");  
CommandMap.setDefaultCommandMap(mc);