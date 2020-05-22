Etat etat = Etat.Actif ;

    this.tv_ListUsers_cl_Etat.setCellFactory(ComboBoxTableCell.<Utilisateur,Etat>forTableColumn(etat.values()));
    tv_ListUsers_cl_Etat.setOnEditCommit(
        (CellEditEvent<Utilisateur, Etat> t) -> {

            if (t.getNewValue().equals(Etat.Actif)) {
                ((Utilisateur) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setEtat(Etat.Actif);
            } else {
                ((Utilisateur) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setEtat(Etat.Bloque);

            }

        });