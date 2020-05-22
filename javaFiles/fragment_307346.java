:
    :
public void createClientArray()
{
  // Create an ArrayList of Client
  ArrayList<Client> clients = new ArrayList<Client>();

  // Instantiate Client class to store the information
  Client clientObject = new Client();
  clientObject.setName("Client Name");
  clientObject.setId(1);
  clientObject.setValue("Any Value");

  // Add to the ArrayList
  clients.add(clientObject);

  // Store another client's information
  Client clientObject2 = new Client();
  clientObject2.setName("Client Name 2");
  clientObject2.setId(2);
  clientObject2.setValue("Any Value 2");
      :
      :

}
    :
    :