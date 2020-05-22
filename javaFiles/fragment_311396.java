String ss = "[Pastatas{pastatoAdresas='RandomAdresas0',pastatoAukstuSkaicius=100,pastatoPastatymoData=2018, pastatoButuKiekis=1}]";
Pattern pattern = Pattern.compile("=(.*?)[,}]");
Matcher matcher = pattern.matcher(ss);
while (matcher.find()) {
    System.out.println(matcher.group(1).replace("'", ""));
}