lAgenda.selectedAppointments().addListener(new ListChangeListener< Appointment >() {
     public void onChanged(Change<? extends Appointment> c) {
         while (c.next()) {
             if (c.wasPermutated()) {
                 for (int i = c.getFrom(); i < c.getTo(); ++i) {
                      //permutate
                 }
             } else if (c.wasUpdated()) {
                      //update item
             } else {
                 for (Appointment a : c.getRemoved()) {
                 }
                 for (Appointment a : c.getAddedSubList()) {
                     printAppointment(a);
                 }
             }
         }
     }
 });