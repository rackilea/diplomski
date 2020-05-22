ArrayList<Integer> listOfSpinners = new ArrayList<Integer>();
listOfSpinners.add(R.id.spinner);
listOfSpinners.add(R.id.spinner2); 

ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this,
            R.layout.spinnerlayout, infoInSpinner);

adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
for (Integer spinner : listOfSpinners) {
    // If you want multiple adapters, move the adapter code in here and alter it accordingly.
    ((Spinner) findViewById(spinner)).setAdapter(adapterSpinner);
}