SwingWorker<Void, Articulos> worker = new SwingWorker<Void, Articulos>() {
    @Override
    protected Void doInBackground() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidosPU" );
        EntityManager em = emf.createEntityManager();

        String jqpl = "SELECT a FROM Articulos a WHERE a.entregado = :param";
        TypedQuery<Articulos> query = em.createQuery(jpql, Articulos.class);
        query.setParameter("param", "P");

        List<Articulos> resultList = query.getResultList();

        publish((Articulos[])resultList.toArray());

        em.close();
        emf.close();
    }

    @Override
    protected void process(List<Articulos> chunks) {
        // add your items to the table model here
        // this code runs in the EDT
    }

    @Override
    protected void done() {
        refreshButton.setEnabled(true);
    }    
};

worker.execute();