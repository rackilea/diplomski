public static void serializeObject( Log l, String Pression,i nt ID) {

    XStream x = new XStream();
    x.autodetectAnnotations(true);

    x.alias("Log", LogBook.class);                      // rename o root node  or the class
    x.alias("LogBook", Log.class);

    x.aliasField("IDLogbook" , LogBook.class, "idLogBook"); // rename  attribute class
    x.aliasField("DateDive" , LogBook.class, "date");
    x.aliasField("Local" , LogBook.class, "local");
    x.aliasField("Contry" , LogBook.class, "Contry");
    x.aliasField("City" , LogBook.class, "city");
    x.aliasField("State" , LogBook.class, "State");
    x.aliasField("boddy" , LogBook.class, "boddy");
    x.aliasField("operator" , LogBook.class, "operator");
    x.aliasField("modality" , LogBook.class, "modality");
    x.aliasField("category" , LogBook.class, "category");
    x.aliasField("qualityDive" , LogBook.class, "qualityDive");
    x.aliasField("UsedTable" , LogBook.class, "UsedTable");
    x.aliasField("hourBegin" , LogBook.class, "hourBegin");

    x.aliasField("PEA" , LogBook.class, "PEA");
    x.aliasField("PPO2" , LogBook.class, "PPO2");

    x.aliasField("visibility" , LogBook.class, "visibility");
    x.aliasField("Manômetro" , LogBook.class, "manometro"); 
    x.aliasField("cilindermodel" , LogBook.class, "cilindermodel");
    if (Pressao.equals("Bar")){
        x.aliasField("PressionIN" , LogBook.class, "pressionInBar");
        x.aliasField("PressionOUT" , LogBook.class, "pressionOutBar");  
    }else{
        x.aliasField("PressionIN" , LogBook.class, "pressionInPsi");    
        x.aliasField("PressionOUT" , LogBook.class, "pressionOutPsi");  
    }

    x.aliasField("Oxigen" , LogBook.class, "Oxigen");   
    x.aliasField("Nitorgen" , LogBook.class, "Nitorgen");

    x.omitField(LogBook.class, "tipoPressionPSI"); // turn field hold
    x.omitField(LogBook.class, "eanX");

    x.alias("Caverna", LogBookCaverna.class);

    x.aliasField("IDLogbook" , LogBookCaverna.class, "idLogBook");  // renomeia o atributo da classe
    x.aliasField("NomeCaverna" , LogBookCaverna.class, "nomeCaverna");      
    x.aliasField("ComoChegar" , LogBookCaverna.class, "comoChegar");
    x.aliasField("Profundidade" , LogBookCaverna.class, "profundidadeM");
    x.aliasField("Penetração" , LogBookCaverna.class, "penetracaoM");
    x.aliasField("RotaUsada" , LogBookCaverna.class, "rotaUsada");
    x.aliasField("EquipEspeologiaUsado" , LogBookCaverna.class, "equipUsado");
    x.aliasField("Obs" , LogBookCaverna.class, "obs");
    x.omitField(LogBookCaverna.class, "penetracaoMaxConhecidaM");   // omite o atributo da classe
    x.omitField(LogBookCaverna.class, "penetracaoMaxConhecidaF");
    x.omitField(LogBookCaverna.class, "profundidadeMaxConhecidaM");
    x.omitField(LogBookCaverna.class, "profundidadeMaxConhecidaF");     
    x.omitField(LogBookCaverna.class, "idLogBookCaverna");  
    x.omitField(LogBookCaverna.class, "LogBookCaverna");

    x.alias("Complement", LogBookComplement.class);

    x.aliasField("Complemento" , LogBookComplemento.class, "complemento");
    x.aliasField("IDLogbook" , LogBookComplemento.class, "idLogBook");  // renomeia o atributo da classe
    x.aliasField("Tempo" , LogBookComplemento.class, "tempo");
    x.aliasField("Entrada" , LogBookComplemento.class, "entrada");
    x.aliasField("TipoÁgua" , LogBookComplemento.class, "tipoAgua");
    x.aliasField("CondiçãoMar" , LogBookComplemento.class, "condicoesMar");
    x.aliasField("Acesso" , LogBookComplemento.class, "acessoLocal");
    x.aliasField("Facilidades" , LogBookComplemento.class, "facilidades");
    x.aliasField("Dificuldades" , LogBookComplemento.class, "dificuldades");        
    x.aliasField("Corrente" , LogBookComplemento.class, "correnteMaritima");
    x.aliasField("Obs" , LogBookComplemento.class, "obs");
    x.omitField(LogBookComplemento.class, "idLogBookComplemento");  
    x.omitField(LogBookCaverna.class, "LogBookComplemento");    

    x.alias("Custos", LogBookCustos.class);
    x.aliasField("IDLogbook" , LogBookCustos.class, "idLogBook");   // renomeia o atributo da classe
    x.aliasField("CustoViagem" , LogBookCustos.class, "custoViagem");
    x.aliasField("CustoEmbarcação" , LogBookCustos.class, "custoEmbarcacao");
    x.aliasField("CustoEquipamentos" , LogBookCustos.class, "custoEquipamentos");
    x.aliasField("CustoDeslocamento" , LogBookCustos.class, "custoDeslocamento");
    x.aliasField("CustosDiversos" , LogBookCustos.class, "custoDiversos");
    x.aliasField("Obs" , LogBookCustos.class, "obs");
    x.omitField(LogBookCustos.class, "logBook");
    x.omitField(LogBookCustos.class, "custoFinal");

    x.alias("Embarcação", LogBookEmbarcacao.class);
    x.aliasField("IDLogbook" , LogBookEmbarcacao.class, "IDLogbook");
    x.aliasField("NomeEmbarcação" , LogBookEmbarcacao.class, "nomeEmbarcacao");
    x.aliasField("Comprimento" , LogBookEmbarcacao.class, "comprimentoM");
    x.aliasField("CapitãoMestre" , LogBookEmbarcacao.class, "capitaoMestre");
    x.aliasField("NúmMergulhadores" , LogBookEmbarcacao.class, "numMergulhadores");
    x.aliasField("Obs" , LogBookEmbarcacao.class, "obs");
    x.omitField(LogBookEmbarcacao.class, "idLogBookEmbarcacao");
    x.omitField(LogBookEmbarcacao.class, "logBook");
    x.omitField(LogBookEmbarcacao.class, "equipSeguranca");
    x.omitField(LogBookEmbarcacao.class, "velocidade");
    x.omitField(LogBookEmbarcacao.class, "oxigenio");
    x.omitField(LogBookEmbarcacao.class, "camarotes");
    x.omitField(LogBookEmbarcacao.class, "banheiro");
    x.omitField(LogBookEmbarcacao.class, "salaTV");
    x.omitField(LogBookEmbarcacao.class, "detalhesEmbarque");
    x.omitField(LogBookEmbarcacao.class, "qualidadePlataforma");

    x.alias("Naufrágio", LogBookNaufragio.class);
    x.aliasField("IDLogbook" , LogBookNaufragio.class, "IDLogbook");
    x.aliasField("NomeNaufrágio" , LogBookNaufragio.class, "nomeNaufragio");
    x.aliasField("VisibilidadeMédia" , LogBookNaufragio.class, "IDLogbook");
    x.aliasField("Penetração" , LogBookNaufragio.class, "IDLogbook");
    x.aliasField("Comprimento" , LogBookNaufragio.class, "comprimentoM");
    x.aliasField("ComoAfundou" , LogBookNaufragio.class, "IDLogbook");
    x.aliasField("TipoNaufrágio" , LogBookNaufragio.class, "tipoNaufragio");
    x.aliasField("TipoEmbarcação" , LogBookNaufragio.class, "tipoEmbarcacao");
    x.aliasField("ProfPopa" , LogBookNaufragio.class, "popaM");
    x.aliasField("ProfProa" , LogBookNaufragio.class, "proaM");
    x.aliasField("Obs" , LogBookNaufragio.class, "obs");
    x.omitField(LogBookNaufragio.class, "propulsao");
    x.omitField(LogBookNaufragio.class, "peso");
    x.omitField(LogBookNaufragio.class, "comprimentoF");
    x.omitField(LogBookNaufragio.class, "bocaM");
    x.omitField(LogBookNaufragio.class, "bocaF");
    x.omitField(LogBookNaufragio.class, "lancadoEm");
    x.omitField(LogBookNaufragio.class, "afundouEm");
    x.omitField(LogBookNaufragio.class, "popaF");
    x.omitField(LogBookNaufragio.class, "proaF");


    x.aliasField("IDLogbook" , LogBookFauna.class, "idLogBook");
    x.aliasField("Fauna" , LogBookFauna.class, "descricaoFauna");   

    String CAMINHO_XML = Environment.getExternalStorageDirectory() + "/Dive/logbook_" + ID + ".xml";


    File arquivo = new File(CAMINHO_XML);

    FileOutputStream gravar;
    try {
        gravar = new FileOutputStream(arquivo);
        //gravar.write(x.toXML(l).getBytes());
        gravar.write(x.toXML(l).toString().replace(".", ",").getBytes());
        gravar.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }

}