System.setSecurityManager(new SecurityManager() {
        @Override
        public void checkExit(int status) {
            throw new AccessControlException("exit not allowed during testing");
        }
    });