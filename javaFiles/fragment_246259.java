public void onTaskComplete(Object[] output) {
    super.onTaskComplete(output);   
    Integer resultOperation = (Integer) output[0];

    if (output != null && resultOperation != 500) {
        String typeTask = (String) output[1];
        if (typeTask.equals("SearchListVisite")) {
            switch (resultOperation) {
            case 200:
                Visita[] visite_current_patient = (Visita[]) output[2];
                if(visite_current_patient.length < 2) {
                    visite_current_patient = createVisteListEmpty();
                }
                fillVisiteList(visite_current_patient);
                break;
            case 204:
                Visita[] visitaEmpty = createVisteListEmpty();
                fillVisiteList(visitaEmpty);
                break;
            }

    } else {
        CharSequence testo = "Errore!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, testo, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        onBackPressed();
    }
    } 
}