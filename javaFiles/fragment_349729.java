List<String> consoleLogs = new ArrayList<>();
    project.addBuildListener(new BuildListener() {
        @Override
        public void buildStarted(BuildEvent buildEvent) {

        }

        @Override
        public void buildFinished(BuildEvent buildEvent) {
            if(buildEvent.getException()  != null && StringUtils.hasText(buildEvent.getException().getMessage())){
                consoleLogs.add(buildEvent.getException().getMessage());
            }
        }

        @Override
        public void targetStarted(BuildEvent buildEvent) {

        }

        @Override
        public void targetFinished(BuildEvent buildEvent) {

        }

        @Override
        public void taskStarted(BuildEvent buildEvent) {

        }

        @Override
        public void taskFinished(BuildEvent buildEvent) {

        }

        @Override
        public void messageLogged(BuildEvent buildEvent) {
            if(StringUtils.hasText(buildEvent.getMessage())) {
                consoleLogs.add(buildEvent.getMessage());
            }
        }
    });