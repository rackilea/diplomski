QDataWidgetMapper *mapper = new QDataWidgetMapper;
mapper->setModel(model);
mapper->addMapping(mySpinBox, 0);
mapper->addMapping(myLineEdit, 1);
mapper->addMapping(myCountryChooser, 2);
mapper->toFirst();