int n = tblView.getItems().size();

for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            u1 = tblView.getItems().get(i).getutilidadGeneral();
            u2 = tblView.getItems().get(j).getutilidadGeneral();
        }
}