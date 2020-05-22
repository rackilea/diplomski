try{
    tSub.close();
    tSession.close();
    tCon.close();
    incrementMetric.invoke("JMS-disconnect-count");
} catch...