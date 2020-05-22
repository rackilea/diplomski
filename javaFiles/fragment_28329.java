// mock code added so that the above code will compile and run
// because you didn't give us this code
class QueryBuilderMethods {

   public DefaultComboBoxModel<String> getAllRepositoryName() {
      DefaultComboBoxModel<String> cModel = new DefaultComboBoxModel<>();
      for (String item : new String[] { "one", "two", "three", "four", "five" }) {
         cModel.addElement(item);
      }
      return cModel;
   }

   public List<String> getAllColumnsForTable(String string) {
      List<String> columns = new ArrayList<>();
      for (String item : new String[] { "col 1", "col 2", "col 3", "col 4" }) {
         columns.add(item);
      }
      return columns;
   }

   public DefaultComboBoxModel<String> getAllTablesForRepo(String string) {
      DefaultComboBoxModel<String> cModel = new DefaultComboBoxModel<>();
      for (String item : new String[] { "repo one", "repo two", "repo three",
            "repo four", "repo five" }) {
         cModel.addElement(item);
      }
      return cModel;
   }

}