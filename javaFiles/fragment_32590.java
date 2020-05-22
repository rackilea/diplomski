private void displayAppointmentNotification() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");

    Timer timer = new Timer();

    TimerTask task = new TimerTask() {

        @Override
        public void run() {
            try {
                ps = HospitalDB.getCon().prepareStatement("Select * From Notification");
                rs = ps.executeQuery();

                while (rs.next()) {

                    if (rs.getString("Reminder").contentEquals(dateFormat.format(new Date()))) {
                        Notifications noti = Notifications.create();
                        noti.text("Doctor " + rs.getString("Doctor") + " has an Appointment with Patient " + rs.getString("Patient"));
                        noti.title("Appointment");
                        noti.hideAfter(Duration.seconds(30));
                        noti.position(Pos.BOTTOM_RIGHT);

                        Platform.runLater(() -> {
                            noti.show();
                        });

                        //Change The Appointment Status to Done
                        ps = HospitalDB.getCon().prepareStatement("Update Appointment Set Status=? Where Patient=? and Doctor=?");
                        ps.setString(1, "Done");
                        ps.setString(2, rs.getString("Patient"));
                        ps.setString(3, rs.getString("Doctor"));
                        ps.executeUpdate();

                        populateTable();
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    };
    timer.schedule(task, 0, 1 * 1000);
}