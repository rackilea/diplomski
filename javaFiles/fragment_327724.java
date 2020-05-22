String split[] = name.trim().split(" ");     // Trim the multiple spaces inside to avoid empty parts
StringBuilder sb = new StringBuilder();      // StringBuilder builds the String

for (int i=0; i<split.length; i++) {                      // Iterate the parts
    if (i<split.length -1) {                              // If not the last part
        sb.append(split[i].charAt(0)).append(". ");       // Append the first letter and a dot
    } else sb.append(split[i]);                           // Or else keep the entire word
}

System.out.println(sb.toString());           // StringBuilder::toString returns a composed String