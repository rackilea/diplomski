public class Client {
    public static void main(String[] args) {
        FinestraPrincipale finestraPrincipale = new FinestraPrincipale();
        GestoreDb gestoreDb = new GestoreDb();


        String adessoFormatoMySql = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));

        List<RecordBean> lista = gestoreDb.getRecordsDaDate("2019-01-26 18:00:00", adessoFormatoMySql);

        finestraPrincipale.avvia();
        finestraPrincipale.aggiornaTabella(lista);
    }
}