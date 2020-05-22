List<EmailQueue> emailList = em.createQuery(sql).getResultList();
        for (EmailQueue obj : emailList) {
              String emailStatus = "DONE";
              String errormsg=sendEmail(obj.getRecipient(), obj.getSubject, obj.getContent(),obj.getId(),obj.getUsername());
                    if (!errormsg.equals("")) {
                        emailStatus = "FAILED"
                    }
                    TerminalLogger.printMsg("Status  : " + emailStatus);
        }

    }