public void testEntityObject()
{
    System.out.println("Let's try our Entity Object...");

    try
    {
        EntityDefImpl entity = TesteEOImpl.getDefinitionObject();
        TesteEOImpl ti = (TesteEOImpl)entity.createInstance2(getDBTransaction(), null);
        ti.setId(new BigDecimal(123));
        ti.setNome("Entity Object test...");

        getDBTransaction().commit();

        System.out.println("Looks good :-)");
    }
    catch(Exception e) 
    {
        System.out.println("It seems something went wrong :-(");
        e.printStackTrace();
    }
}

public void testViewObject() {
    System.out.println("Let's try our View Object...");

            ViewObjectImpl vo = this.getTeste1();

        try{
            Row row = vo.createRow();
            row.setAttribute("Id", 234);
            row.setAttribute("Nome", "VO test");
            vo.insertRow(row);
            getDBTransaction().commit();
            System.out.println("Looks good :-)")
        }
        catch(Exception e) {
            System.out.println("It seems something went wrong :-(");
            e.printStackTrace();
        }

    }