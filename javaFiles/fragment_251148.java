public void Notestore() {

    System.out.println("Enter the note ID you wish to attach the note with\n\n");
    String inputIDnote = inputID.nextLine();
    System.out.println("Enter your note\n\n");
    String noteDescription = inputID.nextLine();  //No need for two scanner
    System.out.println("" + inputIDnote + "\n" + noteDescription);
    Note.add(new NoteInfomation(inputIDnote, noteDescription));
}