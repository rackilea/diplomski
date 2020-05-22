@Override
public void changed(ObservableValue<? extends String>  observable, String oldValue, String idvalue) {

    Query query3 = entityManager.createQuery("FROM Patient WHERE idpatient=:idpatient");
    query3.setParameter("idpatient", idvalue);

    Patient p = (Patient) query.getSingleResult();


    infoPIDField.setText(p.getPIDField());
    infonameField.setText(p.getNameField());
    infolastNameField.setText(p.getLastNameField());
    ...........


}