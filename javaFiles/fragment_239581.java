public void displayResults(String url, JTextArea area) {

    //number of episode
    int num = 1;
    dates.clear();

    //Get the URL from JTextField that will be passed as a parameter of this method
    webData.setup(url);

    String result = "";

    for (int i = 0; i < webData.getDates().size(); i++) {
        result += "Episode " + num++ + ": " + webData.getEpisodeTitle().get(i) + "\n" + "Air date: "
                + webData.getDates().get(i) + "\n\n";
    }
    //Set the text of JTextArea with the values produced in loop above
    area.setText(result);
}