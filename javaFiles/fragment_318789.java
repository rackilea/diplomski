String username= users.getUsername();
                    List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(users, false);
                    for(SessionInformation information : sessionInformations){
                        if(username.equalsIgnoreCase(user.getUserName())) {
                             information.expireNow();
                         }
                    }
                }
            }