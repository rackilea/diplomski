ComboBox<Client> clientSelection = new ComboBox<Client>("client");

clientSelection.setItems(clientService.findAll()); // list/set of possible clients.

// Using clients name for item captions now, but you can also use id or both
clientSelection.setItemCaptionGenerator(Client::getName); 

binder.forField(clientSelection)
            .bind(Order::getClient, Order::setClient);