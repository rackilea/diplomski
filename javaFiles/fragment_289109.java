this.getModel().addTableModelListener(e -> { // TableModelListener
            SwingUtilities.invokeLater(() -> { // Runnable
                switch (e.getType()) {
                    case TableModelEvent.DELETE:
                        refreshTable();
                        break;
                    case TableModelEvent.INSERT:
                        refreshTable();
                        break;
                    case TableModelEvent.UPDATE:
                        refreshTable();
                        break;
                }
            });
        });