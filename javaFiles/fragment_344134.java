JPanel panel = new JPanel(new GridLayout(2, 1)); // layout sets combobox under label
JLabel label = new JLabel("#5 Que describe mejor a la Norteña?");
JComboBox selection = new JComboBox(new String[]{"Ensalada de espinacas, tomates, zetas, cebolla, tocineta, aguacate, queso de hoja y tiras de maiz crujientes en vinagreta de la casa.",
            "Lechuga romana servida con tomate, cebolla, maiz, aguacate, queso de hoja y tiritas de maiz crujientes acompañado de su seleccion de filetes de pollo de res.",
            "Ensalada vegetariana de nopales, tomates, cebolla, lechuga romana, queso de hoja, aguacate, y aderezo especial de la casa."});
String[] options = {"OK"};
panel.add(label);
panel.add(selection);
JOptionPane.showOptionDialog(null, panel, "Examen Tijuanas PR",
     JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
     null, options, options[0]);