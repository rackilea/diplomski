private final Service<Image> imageRetrievalService = new Service<Image>() {
    @Override
    protected Task<Image> createTask() {
        final String id ;
        final Visitante visitante = tbvisitantes.getSelectionModel().getSelectedItem();
        if (visitante == null) {
            id = null ;
        } else {
            id = visitante.getCedula();
        }
        return new Task<Image>() {
            @Override
            protected Image call() throws Exception {
                if (id == null) {
                    return null ;
                }
                return dataAccessor.getImageById(id);
            }
        } ;
    }
};