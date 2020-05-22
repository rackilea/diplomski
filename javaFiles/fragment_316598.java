try {
    final YouTube.Videos.Rate request = youtubeService.videos().rate(VID, "like");

    runOnUiThread(new Runnable() {
        public void run() {

            HttpResponse response = request.executeUnparsed();

            // There should be a matching constant for 204 defined somewhere, I haven't found it yet
            if (response.getStatusCode() == 204) {
                //  request successfull
            }
        }
    });
} catch (IOException e) {
    e.printStackTrace();
}