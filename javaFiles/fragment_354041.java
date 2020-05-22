public List<BillDetails> BillnAmountFetch(long cid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        ArrayList<BillDetails> ar = new ArrayList<BillDetails>();
        BillDetails bd = null;
        try {
            String hql = "select count(billNo), sum(total), invoiceDate from BillDetails "
                    + "where client.id=:cid "
                    + "group by invoiceDate  "
                    + "order by invoiceDate DESC";

            Query query;
            query = session.createQuery(hql);
            query.setParameter("cid", cid);

            Iterator results = query.list().iterator();
            while (results.hasNext()) {
                Object[] row = (Object[]) results.next();
                Long count = (Long) row[0];
                BigDecimal amount = (BigDecimal) row[1];
                Date dt = (Date) row[2];
                System.out.println(count + " " + amount + " " + dt);
                bd = new BillDetails();
                bd.setTotalBills(count);
                bd.setTotalAmount(amount);
                bd.setInvoiceDate(dt);
                ar.add(bd);
            }
            System.out.println("--------------------------");
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                e.printStackTrace();
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return ar;
    }

    public static void main(String[] args) {
        BillDAO bdo = new BillDAO();
        ArrayList<BillDetails> ar = (ArrayList<BillDetails>) bdo.BillnAmountFetch(1);
        System.out.println("In main method");
        for(BillDetails b:ar){
           System.out.println(b.getTotalBills() + " " + b.getTotalAmount() + " " + b.getInvoiceDate());
        }

    }