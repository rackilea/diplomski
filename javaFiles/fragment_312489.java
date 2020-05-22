} catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    ResultTable result = new ResultTable(data);
    JTable table = new JTable(result);
    JScrollPane scrollpane = new JScrollPane(table);
    add(scrollpane);
    refresh();
}