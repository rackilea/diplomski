c.anchor = GridBagConstraints.CENTER; // Redundant - default
addobjeto(title, 0, 0, 2, 1);

c.anchor = GridBagConstraints.LINE_START;
c.fill = GridBagConstraints.HORIZONTAL;
addobjeto(nombreingreso2, 0, 1, 1, 1);
addobjeto(nombreingreso3, 1, 1, 1, 1);

addobjeto(ingreso2, 0, 2, 1, 1);
addobjeto(ingreso3, 1, 2, 1, 1);

addobjeto(frecuencia2, 0, 3, 1, 1);
addobjeto(frecuencia3, 1, 3, 1, 1);

c.anchor = GridBagConstraints.CENTER;
c.fill = GridBagConstraints.NONE;
addobjeto(aceptar, 0, 4, 2, 1);