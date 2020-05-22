if (choice == 6) {
                    removeCourse();

                }
                if (choice == 7) {
                    addFaculty();
                }
                if (choice == 8) { // LIST OF FACULTY
                    String d1 = "";
                    for (FacultyMember d : faculty) {
                        // b.toString();
                        d1 = d1 + d.toString() + "\n";

                    }
                    JOptionPane.showMessageDialog(null, d1);
                }
                if (choice == 9) { // REMOVE FACULTY
                    removeFaculty();
                }