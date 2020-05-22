@Override
public void showNewArticles(Article a) throws RemoteException {

   IClient client = MainController.getInstance().getClient();
   client.showNewArticles(a);
}