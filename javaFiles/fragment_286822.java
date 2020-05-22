String in = " url = http://184.154.145.114:8013/wlraac name = wlr  samplerate = 44100 channels = 2       format = S16le";

Pattern r = Pattern.compile(".*name =\\s*(\\w+).*");
Matcher m = r.matcher(in);

String result = m.replaceAll("$1");
System.out.println(result);