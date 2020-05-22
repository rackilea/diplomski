public static void menuVehiculos() {

        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite \n1.Ingresar nuevo vehiculo. \n2.Lista actual de vehiculos. \n3.Eliminar vehiculo. \n4.Salir "));

        switch (n) {
            case 1:
                Rutinas.nuevoVehiculo();
                Rutinas.menuVehiculos();
                break;

            case 2:
                Rutinas.listaVehiculos();
                Rutinas.menuVehiculos();
                break;

            case 3:
                Rutinas.eliminarVehiculo();
                Rutinas.menuVehiculos();
                break;

            case 4:
                JOptionPane.showMessageDialog(null, "Gracias.");
                break;

        }

    }//Fin Menu.