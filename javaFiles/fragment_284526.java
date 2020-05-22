public void manipulatePdf(String src, String dest) throws DocumentException, IOException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    AcroFields form = stamper.getAcroFields();
    form.setField("course", "Copying and Pasting from StackOverflow");
    form.setField("name", "Some dude on StackOverflow");
    form.setField("date", "April 10, 2016");
    form.setField("description",
        "In this course, people consistently ignore the existing documentation completely. "
        + "They are encouraged to do no effort whatsoever, but instead post their questions "
        + "on StackOverflow. It would be a mistake to refer to people completing this course "
        + "as developers. A better designation for them would be copy/paste artist. "
        + "Only in very rare cases do these people know what they are actually doing. "
        + "Not a single student has ever learned anything substantial during this course.");
    stamper.setFormFlattening(true);
    stamper.close();
}