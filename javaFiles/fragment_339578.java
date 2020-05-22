public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
            ReadFile data = new ReadFile();
            String line = data.readfile();
            Test test = getTestObjectFromCSV(line) // a function that takes csv and returns Test class obejct
            kSession.insert(test);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }