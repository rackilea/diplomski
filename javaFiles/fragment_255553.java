class MyRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(...) {
            super.getList...
            if (value instanceof File) {
                setText(FileSystemView.getFileSystemView().getDisplayName(value);
                setIcon(FileSystemView.getFileSystemView().getSystemIcon(value);
            } 
            return this;
        }

   }