XtkSession token  = new XtkSession();
            SessionMethodsSoap token_soap = token.getSessionMethodsSoap();          
            String sessiontoken = "";
            String strLogin = "admin";
            String strPassword = "password";
            xtk.session.Element elemParameters = new xtk.session.Element();
            Holder<String> pstrSessionToken = new Holder<String>();
            Holder<xtk.session.Element> pSessionInfo = null;
            Holder<String> pstrSecurityToken = new Holder<String>();

            token_soap.logon(sessiontoken, strLogin, strPassword, elemParameters, pstrSessionToken, pSessionInfo, pstrSecurityToken);