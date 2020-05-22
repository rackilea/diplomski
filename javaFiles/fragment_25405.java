@Override
public void onItemSelected(AdapterView<?> spinner, View view, int position,long id)
{
     FirstValue = spinner.getItemAtPosition(position).toString();
        checkIfConvertingFromMeter(itemSelectedInSpinnerLengthInput);
}