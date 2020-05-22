Object selectedValues=twinSelect.getValue();

twinSelect.removeAllItems();

twinSelect.addItems(newITemsList);

(Collection<?>selectedValues.forEach(o ->twinSelect.addItem(o));

twinSelect.setValue(selectedValues);