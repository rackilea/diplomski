boxLeague.getSelectionModel().selectedItemProperty().addListener(
  (observable, oldValue, newValue) -> { 
      if (newValue.equals("Premier League")) {
          boxTeams.setItems(listPremierLeague));
      } // else if ... (or use a switch-case here)
  }
);