final Slider slider = new Slider(shell, SWT.NONE);
  slider.setMaximum(100);
  slider.setMinimum(0);
  slider.setThumb(20);

  slider.addSelectionListener(new SelectionListener() {

    @Override
    public void widgetSelected(SelectionEvent e) {
        System.out.println( slider.getSelection()  +"   "+ slider.getThumb());
    }

    @Override
    public void widgetDefaultSelected(SelectionEvent e) {

      // TODO Auto-generated method stub

    }
  });