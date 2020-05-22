switch(choice){
case 6: removeCourse();
        break;
case 7: addFaculty();
        break;
case 8: String d1 = "";
        for (FacultyMember d : faculty) {
        // b.toString();
        d1 = d1 + d.toString() + "\n";}
        JOptionPane.showMessageDialog(null, d1);
        break;
case 9: removeFaculty();
        break;
}