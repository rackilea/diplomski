StringBuilder sb = new StringBuilder();

boolean firstTime = true;

for (String str : list) {

    if (firstTime) {
        firstTime = false;
    } else {
        sb.append(",");
    }

    sb.append(str);
}