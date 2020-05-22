Master master = new Master();
master.id(masterPk);    

Detail detail = new Detail();
detail.id(detailPk);
detail.setMaster(master); // the owning side of the master-detail relationship

master.setDetail(detail); // mandatory if CascadeType.PERSIST is not defined
em.persist(detail);