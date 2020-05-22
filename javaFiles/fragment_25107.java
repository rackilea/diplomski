@Test
public void comprovarCercaBuuida(){
    // arrange
    DeuteBackBean deuteBB;

    List<IDeute> respostaDeutesExe = new ArrayList<IDeute>();
    List<IDeute> respostaDeutesVol = new ArrayList<IDeute>();
    List<IDeute> respostaDeutesTots = new ArrayList<IDeute>();

    Mockito.when(serveiGpt.obtenirDeutes(Mockito.eq(CLAU_SUBJECTE_BUIT),Mockito.eq(E_TIPUS_DEUTE_HIS),Mockito.eq(PERIODE_DEUTE_EXE))).thenReturn(respostaDeutesExe);
    Mockito.when(serveiGpt.obtenirDeutes(Mockito.eq(CLAU_SUBJECTE_BUIT),Mockito.eq(E_TIPUS_DEUTE_HIS),Mockito.eq(PERIODE_DEUTE_VOL))).thenReturn(respostaDeutesVol);
    Mockito.when(serveiGpt.obtenirDeutes(Mockito.eq(CLAU_SUBJECTE_BUIT),Mockito.eq(E_TIPUS_DEUTE_HIS),Mockito.eq(PERIODE_DEUTE_TOTS))).thenReturn(respostaDeutesTots);

    // act
    handler.handle(...); // <-- invoking the handler with fictional name

    // assert
    Mockito.verify(serveiGpt,Mockito.atLeastOnce()).obtenirDeutes(Mockito.eq(CLAU_SUBJECTE_BUIT), Mockito.eq(E_TIPUS_DEUTE_HIS), Mockito.eq(PERIODE_DEUTE_EXE));
    //Mockito.verify(serveiPersones,Mockito.atLeastOnce()).cercarPersones(Mockito.eq(PATRO_CERCA_AMB_RESULTATS), Mockito.any(IPager.class));
    //Mockito.verify(serveiPersones,Mockito.atLeastOnce()).cercarPersones(Mockito.eq(PATRO_CERCA_AMB_RESULTATS), Mockito.any(IPager.class));
}