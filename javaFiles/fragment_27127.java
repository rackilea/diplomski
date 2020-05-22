TableItem[] items = viewer.getTable().getItems();
    File fl = new File(dialog.getFilterPath() + File.separator + dialog.getFileName());
    FileWriter flwr;
    int cls = viewer.getTable().getColumnCount();
            try {
                flwr = new FileWriter(fl);
                for (int i = 0; i < items.length; i++) {
                    for (int j = 0; j <= cls; j++) {
                        flwr.write(items[i].getText(j) + "\t");
                    }
                    flwr.write("\n");
                }
                flwr.flush();
                flwr.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }