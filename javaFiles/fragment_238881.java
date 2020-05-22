public void readLog(HttpRequest req, HttpResponse resp) {

    File file = new File('YOUR_FILE_LOCATION')

    FileReader fr = new FileReader(file);


    // you can read every line for the log file and write into resposne
    while(str = nextLine()) {
        resp.println(str)
    }

    fr.close()  

}