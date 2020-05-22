case (R.id.show_numbers):
    item.setChecked(!item.isChecked());
    showNumbers = item.isChecked();
    yourAdapter.setShowNumbers(showNumbers );
    yourAdapter.notifyDatasetChanged();
    break;