plus = praia + cafe + serv + rest + hot + muse + mon + escolas;
String dados[] = new String[plus];

// categoria is the name of the column
String query = "categoria = ?";

for(i = 1; i < plus; i++){
    query = query + " OR categoria = ?";
}

//if == 1 its active if == 0 its unactive;
cont = 0;

if(praia == 1){
    dados[cont] = "Praias";
    cont++;
}

if(serv == 1){
    dados[cont] = "Servicos";
    cont++;
}

if(cafe == 1){
   dados[cont] = "Cafes";
   cont++;
}

if(rest == 1){
   dados[cont] = "Restaurantes";
   cont++;
}

if(hot == 1){
   dados[cont] = "Hoteis";
   cont++;
}

if(muse == 1){
   dados[cont] = "Museus";
   cont++;
}

if(mon == 1){
   dados[cont] = "Monumentos";
   cont++;
}

if(escolas == 1){
   dados[cont] = "Escolas";
   cont++;
}

String[] projections ={VianaContract.NewLocalInfo.Nome, VianaContract.NewLocalInfo.Categoria, VianaContract.NewLocalInfo.Latitude, VianaContract.NewLocalInfo.Longitude};
cursor = db.query(VianaContract.NewLocalInfo.Table_name, projections, query, dados, null, null, null);