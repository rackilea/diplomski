int[] selected = masterTable.getSelectedRows();
        List<Products> toRemove = new ArrayList<Products>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            Products p = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(p);
            entityManager.remove(p);
        }
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (Exception e) {
        }
        list.removeAll(toRemove);