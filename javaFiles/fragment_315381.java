public static void main(String[] args) throws IOException {
        // Here is where you would assign the content of your HTML element
        // I just put a string there that might resemble what you get from your HTML
        String timeHtmlInput = "12:00\r\n13:00\r\n14:00\r\n";

        // Split by carriage return
        String timeTokens[] = timeHtmlInput.split("\r\n");

        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        String apiToken = "123843242734723";
        String chatId = "@Example";
        String time = timeTokens[0];
        String text = time + "Hello";

        urlString = String.format(urlString, 
                URLEncoder.encode(apiToken, "UTF-8"), 
                URLEncoder.encode(chatId, "UTF-8"),
                URLEncoder.encode(text, "UTF-8"));

        URL url = new URL(urlString);
        System.out.println(url);
        URLConnection conn = url.openConnection();
    }