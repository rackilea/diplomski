public void PrintNotes() {

    for (int i = 0; i < Note.size(); i++) {
        System.out.println(" " + Note.get(i).toString());

        //**or you can also use this
        //  System.out.println("Id:" + Note.get(i).inputIDnote + ", Description: " + Note.get(i).noteDescription);

    }
}