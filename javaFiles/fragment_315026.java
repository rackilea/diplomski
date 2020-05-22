String[] results = text.split("\\|")

String name = results[0];
String age = results[results.length - 1]

String address = results[1];
for (int i = 2; i < results.length-1; i++) {
    address = address + "|" + results[i];
}