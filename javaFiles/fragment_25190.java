public void gestionarEventos(){

    tbvisitantes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<visitantes>() {



        @Override
        public void changed(ObservableValue<? extends visitantes> arg0,
                visitantes valorAnterior, visitantes valorSeleccionado) {

            // cancel any image retrieval and start new one:
            imageRetrievalService.restart();

            if (valorSeleccionado!=null){
                txtcedula.setText(valorSeleccionado.getcedula());
                txtnombres.setText(valorSeleccionado.getnombres();
                txtapellidos.setText(valorSeleccionado.getapellidos());
                txtconjunto.setText(valorSeleccionado.getconjunto()));
                txtapto.setText(valorSeleccionado.getapartamento());
                txtcelular.setText(valorSeleccionado.getcelular());
                txtobservaciones.setText(valorSeleccionado.getobservaciones());
            }
        }
    });

    imgfotovisi.imageProperty().bind(imageRetrievalService.valueProperty());

}