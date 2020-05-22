ticketListView.setCellFactory(new Callback<ListView<Header>,
                                          ListCell<Header>>() {
                                      public ListCell<Header> call(ListView<Header> headerListView) {
                                          return new ListCell<Header>() {
                                              @Override
                                              protected void updateItem(Header item, boolean empty) {
                                                  super.updateItem(item, empty);
                                                  if (item != null) {
                                                      setText(item.getTicket());
                                                  }
                                              }
                                          };
                                      }
                                  }
    );