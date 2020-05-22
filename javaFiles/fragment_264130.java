SoapObject request = new SoapObject("urn:RouterBoxMobile","ListaDetalhe");



    SoapObject chaveIntegracao = new SoapObject("urn:RouterBoxMobile","ListaDetalhe");

    chaveIntegracao.addProperty("ChaveIntegracao","?");
    request.addProperty("Autenticacao",chaveIntegracao);



    SoapObject idTitulo = new SoapObject("urn:RouterBoxMobile","ListaDetalhe");

    idTitulo.addProperty("ID_Titulo",1);


    request.addProperty("tlDadosTitulosDetalhe",idTitulo);

    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
            SoapEnvelope.VER11);




     envelope.setOutputSoapObject(request);