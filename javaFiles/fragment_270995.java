@PostConstruct
    public void init() throws Exception{
        try {
            smackCcsClient.connect(Long.parseLong(env.getProperty("gcm.api")), env.getProperty("gcm.key"));
        }catch (IOException e ){
            e.printStackTrace();
        }catch(SmackException e){
            e.printStackTrace();
        }catch(XMPPException e){
            e.printStackTrace();
        }
    }