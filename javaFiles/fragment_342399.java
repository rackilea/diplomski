try {
        testParent p = new testParent("Dan");
        sid = p.getUuid();

        testChild c1 = new testChild("Dan Jr.");
        testChild c2 = new testChild("Danielle");

        c1.setParent(p);
        c2.setParent(p);
        p.getChildren().add(c1);
        p.getChildren().add(c2);

        session.save(p);            
        tx.commit();

    } catch(Exception e) {
        tx.rollback();
        log.error("Exception occured. "+e.getMessage());
        assertTrue(false);
    }