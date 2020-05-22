String bitcoinUrl = "bitcoin:address?label=mylabel&amount=12";
String address = bitcoinUrl.replaceAll("bitcoin:(.*)\\?.*", "$1");
String label = bitcoinUrl.replaceAll(".*label=(.*)&.*", "$1");
String amount = bitcoinUrl.replaceAll(".*amount=(.*)(&.*)?", "$1");

Log.d("bitcoin", address);
Log.d("bitcoin", label);
Log.d("bitcoin", amount);