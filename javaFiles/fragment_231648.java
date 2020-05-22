public static Map<String, String> vulnerabilityCorrelator(String imageName, String microserviceName) {

    ScannerDAO.em.getTransaction().begin();

    List<Anchore> imageVulns = new ArrayList<Anchore>();
    List<Alert> appVulns = new ArrayList<>();
    Map<String, String> correlatedVulns = new HashMap<String, String>();
    Map<String, String> correlatedAppInfo = new HashMap<String, String>();

    Query appQ = ScannerDAO.em
            .createQuery("SELECT a FROM Alert a WHERE a.microserviceName='" + microserviceName + "'");
    Query imageQ = ScannerDAO.em.createQuery("SELECT i FROM Anchore i  WHERE i.imageName='" + imageName + "'");

    int count = 0;
    int noncorrelatedcount = 0;
    int loopingcounts = 0;

    imageVulns = imageQ.getResultList();
    appVulns = appQ.getResultList();

    List<Vulnerability> vulnList = new ArrayList();
    for (Anchore imageV : imageVulns) {

        vulnList = imageV.getVulnerabilities();
    }


    int loop = 0;
    for (Alert al : appVulns) {

        Alert alert = appVulns.get(loop);
        for (int j = 0; j < vulnList.size(); j++) {

            Vulnerability vulner = vulnList.get(j);
            String appCweId = alert.getCweid();
            String imageCweId = vulner.getCweid();
            String imageCweIdR = null;
            if (imageCweId == null || imageCweId.equals("None")) {

                System.out.println(vulner.getVuln() + " does not have a CWE ID ");
            } else {

                String splitimageCweId[] = imageCweId.split("-");
                imageCweIdR = splitimageCweId[1];


            }
            if (appCweId.equalsIgnoreCase(imageCweIdR) || appCweId == imageCweIdR) {
                System.out.println("correlated  appCweId : " + appCweId + " imageCweId :  " + imageCweIdR);
                count++;
                System.out.println("counting " + count);
                correlatedVulns.put(vulner.getVuln(), vulner.getPackage());
                correlatedAppInfo.put(alert.getAlert(), alert.getCweid());
                System.out.println(vulner.getVuln() + " : " + vulner.getCvssScore());
            } else {
                System.out.println("not correlated appCweId : " + appCweId + " imageCweId : " + imageCweIdR);
                noncorrelatedcount++;
            }

        }
        loop++;
    }

     for (int k = 0; k < correlatedVulns.size(); k++) {

     System.out.println("correlatedVulns " + k +  " : " +  correlatedVulns);
     }

     for (int l = 0; l < correlatedAppInfo.size(); l++) {

         System.out.println("correlatedAppInfo " + l + "  : "  +  correlatedAppInfo);
         }

    return correlatedVulns;

}