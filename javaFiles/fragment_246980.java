listModel.forEach(model -> {
    try {
        new UpDateData().bankData(model.getCust_id(), model.getBank_id(), model.getDate());
    } catch(){
         .... handle
    }
})