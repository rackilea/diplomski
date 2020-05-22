TextField clientId = new TextField("Client ID");
binder.forField(clientId)
    .withConverter(new StringToLongConverter("error message"))
    .bind(
        item -> item.getClient() != null ? item.getClient.getId() : null,
        (item, value) -> {
                if(item.getClient() != null){
                    item.getClient().setId(value);
                }
    });