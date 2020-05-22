public void validateKolicinaCena(FacesContext aContext,UIComponent aComponent,Object aValue) {

int shrani_index = fPodatkiData.getRowIndex();

UIComponent column_kol = fPodatkiData.getChildren().get(2);
UIComponent column_cen = fPodatkiData.getChildren().get(5);

for(int i=0; i<fPodatkiData.getRowCount(); i++) {

    fPodatkiData.setRowIndex(i);

    UIInput kolicina_input = (UIInput) column_kol.findComponent("kolicina");
    UIInput cena_input = (UIInput) column_cen.findComponent("cena");

    Object kolicina = kolicina_input.getLocalValue();
    Object cena = cena_input.getLocalValue();

    if(kolicina == null && cena != null) {

        kolicina_input.setValid(false);

        FacesMessage sporocilo = Sporocila.getMessage("si.alkimisticus.bitea.error", "javax.faces.component.UIInput.REQUIRED", null);
        sporocilo.setSeverity(FacesMessage.SEVERITY_ERROR);

        aContext.addMessage(kolicina_input.getClientId(aContext), sporocilo);

    } else if(kolicina != null && cena == null) {

        cena_input.setValid(false);

        FacesMessage sporocilo = Sporocila.getMessage("si.alkimisticus.bitea.error", "javax.faces.component.UIInput.REQUIRED", null);
        sporocilo.setSeverity(FacesMessage.SEVERITY_ERROR);

        aContext.addMessage(cena_input.getClientId(aContext), sporocilo);

    } else {
        kolicina_input.setValid(true);
        cena_input.setValid(true);
    }


}

fPodatkiData.setRowIndex(shrani_index);}