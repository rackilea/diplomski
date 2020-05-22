public void movePainFiles() {

    File pain008File = new File("C:\\tmp\\pain");
    pain008Files = new ArrayList<File>(Arrays.asList(pain008File.listFiles()));

    System.out.println(pain008Files);

    for (int i = 0; i < pain008Files.size(); i++) {

        System.out.println(pain008Files.get(i).toString());

        pain008Files.get(i).renameTo(new File("C:\\tmp\\archive\\" + "archivedPain_" + pain008Files.get(i).getName()));

    }

}

public void moveCamtFiles() {

    File camt54File = new File("C:\\tmp\\camt");

    camt54Files = new ArrayList<File>(Arrays.asList(camt54File.listFiles()));

    for (int i = 0; i < camt54Files.size(); i++) {

        System.out.println(camt54Files.get(i).toString());
        camt54Files.get(i).renameTo(new File("C:\\tmp\\archive\\" + "archivedCamt_" + camt54Files.get(i).getName()));

    }

}