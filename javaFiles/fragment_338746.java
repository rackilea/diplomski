class SharedListSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
 ListSelectionModel lsm = (ListSelectionModel)e.getSource();
if (!lsm.isSelectionEmpty()) {

CSVReader newCSV = new CSVReader((String)FileList.getSelectedValue());
               table.setModel(newCSV);


}