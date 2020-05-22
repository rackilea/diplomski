String input = "usr/bin/pipe|pipe|name|28|-rwxr-xr-x|root:root||46711b361edd4512814d9b367ae765f42a71d729708b3f2e162acb8f64592610|";
String pipeReplacement = ":124:";
int numberOfPipesToKeep = 7;

String[] split = input.split("\\|");
StringBuilder sb = new StringBuilder();
for (int i = 0; i < split.length; i++) {
    sb.append(split[i]);
    if (i < split.length - numberOfPipesToKeep) {
        sb.append(pipeReplacement);
    } else {
        sb.append("|");
    }
}

String output = sb.toString();
System.out.println(output);