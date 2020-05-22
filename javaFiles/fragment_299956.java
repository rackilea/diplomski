...
 while (true) { 
        try { 
            System.out.println("Esperando la conexion...");
            gestor.agregarTexto("Esperando la conexion..");
            connection = notifier.acceptAndOpen();
            //Ask user if he/she wants to get connected to this device
            int userChoice = JOptionPane.showConfirmDialog(
            null,
            "Would you like to connect to DEVICE_NAME?",
            "Connection Request",
            JOptionPane.YES_NO_OPTION);
            if(userChoice == JOptionPane.YES_OPTION) {
               // Create thread and come out of loop
               Thread processThread = new Thread(new ProcessConnectionThread(connection)); 
               processThread.start();
               break;
            }
            else {
              // user rejected the connection so close the connection here to allow other devices to connect
            }

         } 
         catch (Exception e) { 
             e.printStackTrace(); return; 
          } 
     }
...