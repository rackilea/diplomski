//declaring columns
    String col[] ={"Currency", "Amount"};
    //TableModel
    DefaultTableModel tableModel = new DefaultTableModel (col,0);
    //Your awesome table with tableModel *injected*
    JTable table = new JTable(tableModel);

public void login() {

    Query queryPK = CryptoCurrencyPUEntityManager.createNativeQuery("SELECT t.email, t.user_id FROM usertbl t");
    Query queryFK = CryptoCurrencyPUEntityManager.createNativeQuery("SELECT t.curreny, t.amount FROM CURRENCY t WHERE user_fk=?1 ");

    List<Object[]> results = queryPK.getResultList();
    for(int i = 0; i < results.size(); i++) {
        if(results.get(i)[0].equals(loginEmail)) {
            int fk = (int)(results.get(i)[1]);
            System.out.println(fk);
            queryFK.setParameter(1, fk);
            List<Object[]> currencyTBLresluts = queryFK.getResultList();
            if(currencyTBLresluts != null && !currencyTBLresluts.isEmpty()){
                Object[] array = currencyTBLresluts.toArray(new Object[currencyTBLresluts.size()]);
                ((DefaultTableModel)table.getModel()).addRow(array);
            }
        }
    }    
}