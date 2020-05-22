StringBuilder sb = new StringBuilder();
for (char ch : dna.toCharArray()) {
    switch (ch) {
        case 'A': sb.append('T'); break;
        case 'T': sb.append('A'); break;
        case 'G': sb.append('C'); break;
        case 'C': sb.append('G'); break;
    }
}
String dna2 = sb.toString();