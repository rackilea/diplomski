public boolean isUserExistsInLdap(String emailId, String password) {
        boolean auth = false;
            try {
                auth = ldapTemplate.authenticate("","mail="
                        + emailId, password);
            } catch (Exception e) {
                e.printStackTrace();

            }
          return auth;
    }