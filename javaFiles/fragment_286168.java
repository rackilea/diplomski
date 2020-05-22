DefaultComboBoxModel original = ...;

DecoratedModel firstModel = new DecoratedModel( original );
JComboBox firstCombo = new JComboBox( firstModel );

DecoratedModel secondModel = new DecoratedModel( original );
JComboBox secondCombo = new JComboBox( secondModel );