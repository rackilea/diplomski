final JSpinner spinner1 = new JSpinner(new SpinnerNumberModel(0.0005, 0.0, 1.0, 0.0005)) {
      @Override
      protected JComponent createEditor( SpinnerModel model )
      {
        return new NumberEditor(this, "0.0000");//needed decimal format
      }
    };