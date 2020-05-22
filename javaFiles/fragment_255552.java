fileDropper = new JList(new DefaultListModel());
    fileDropper.setDragEnabled(true);
    leftLowerPanel.setViewportView(fileDropper);

    TransferHandler handler =   new TransferHandler() {

        @Override
        public boolean canImport(TransferHandler.TransferSupport info) {
            // we only import FileList
            if (!info.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                return false;
            }
            return true;
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport info) {
            if (!info.isDrop()) {
                return false;
            }

            // Check for FileList flavor
            if (!info.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                displayDropLocation("List doesn't accept a drop of this type.");
                return false;
            }

            // Get the fileList that is being dropped.
            Transferable t = info.getTransferable();
            List<File> data;
            try {
                data = (List<File>)t.getTransferData(DataFlavor.javaFileListFlavor);
            } 
            catch (Exception e) { return false; }
            DefaultListModel model = (DefaultListModel) fileDropper.getModel();
            for (File file : data) {
                model.addElement(file);
            }
            return true;
        }

        private void displayDropLocation(String string) {
            System.out.println(string);
        }
    };
    fileDropper.setTransferHandler(handler);
    fileDropper.setCellRenderer(new DefaultListRenderer(
          StringValues.FILE_NAME, IconValues.FILE_ICON));