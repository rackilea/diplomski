public void updateUsers(ArrayList<ChatClientInterface> v)
 {
   DefaultListModel<String> listModel = new DefaultListModel();
  if (v != null)
     for (int i = 0; i < v.size(); i++)
     {

        try
        {
           String tmp = ((ChatClientInterface) v.get(i)).getName();
           listModel.addElement(tmp);
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }

     }
  lst.setModel(listModel);
}