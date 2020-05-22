for (int i = 0; i < zakazaneVoznje.size(); i++){
    Voznje v=zakazaneVoznje.get(i)
        prikaz[i][0] = v.getImePrezimeMusterije();
        prikaz[i][1] = v.getDatumPolaska();
        prikaz[i][2] = v.getAdresaPolaska();
        prikaz[i][3] = v.getNacinPorudzbine();
        prikaz[i][4] = v.getVozac();
        prikaz[i][5] = v.getDispecer();
        prikaz[i][6] = v.getVrstaVozila();
        prikaz[i][7] = v.getNapomena();
}