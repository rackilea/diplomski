public class MyServiceASImpl implements MyServiceAS {    

    public void preRemove(final Object objet) {
        ApplicationContextProvider.getApplicationContext().getBean(MyRepository.class)
            .gererAuditCasPreSuppression(objet);
    }
}