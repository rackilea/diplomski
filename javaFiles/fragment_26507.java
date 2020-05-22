Object[] headers = new Object[tableModel.getColumnCount()]; 
forEach (model-column)
    if (index == renamedColumn)
       headers[index] = newHeader
    else
       headers[index] = tableModel.getColumnName(index)
tableModel.setColumnIdentifiers(headers)