while(rs.hasNext())
    {
        QuerySolution sol = rs.nextSolution();
        RDFNode object = sol.get("object"); 
        RDFNode predicate = sol.get("predicate"); 
        RDFNode subject = sol.get("subject");

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{subject, predicate, object});
    }