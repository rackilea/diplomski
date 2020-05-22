CupsClient cupsClient = new CupsClient(IP, port);
URL url = new URL(printerName);
CupsPrinter cupsPrinter = cupsClient.getPrinter(url);
HashMap<String, String> map = new HashMap<>();
map.put("document-format", "application/vnd.cups-raw");
PrintJob printJob = new PrintJob.Builder(bytes).attributes(map).build();
PrintRequestResult printRequestResult = cupsPrinter.print(printJob);