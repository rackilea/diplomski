itemmodel.setRowCount(0);
        item = model.getItem();

        people = model.getCategory();

        for (Category cate : categoryList) {
            categoryBox.addItem(cate.getName());
        }
        for (Item ite : item) {
            itemmodel.addRow(new Object[] { ite.getId(),ite.getName(),  
                    ite.getCategory(), ite.getCompany() });
        }
        item.clear();

        TableColumn categoryColumn = itemTable.getColumnModel().getColumn(2);
        categoryColumn.setCellEditor(new DefaultCellEditor(categoryBox));