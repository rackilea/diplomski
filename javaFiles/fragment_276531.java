Combo firstCombo = new Combo(parent, SWT.READ_ONLY);

String[] itemsArray = {"1", "2", "3"};

firstCombo.setItems(itemsArray);

firstCombo.select(0);

Combo secondCombo = new Combo(parent, SWT.READ_ONLY);

String[] array1 = {"1a", "1b"};
String[] array2 = {"2a", "2b"};
String[] array3 = {"3a", "3b"};

String[][] arrays = {array1, array2, array3};

secondCombo.setItems(arrays[0]);

secondCombo.select(0);

// Selection listener to change second combo

firstCombo.addSelectionListener(new SelectionAdapter()
  {
    @Override
    public void widgetSelected(final SelectionEvent event)
    {
      int index = firstCombo.getSelectionIndex();

      secondCombo.setItems(arrays[index]);

      secondCombo.select(0);
    }
  });