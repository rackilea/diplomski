public static void main(String[] args) {
    for (long l = 1010101010; l < 1389026623; l++) {
        long squared = l * l;
        String s = Long.toString(squared);
        if (s.charAt(0) != '1') continue;
        if (s.charAt(2) != '2') continue;
        if (s.charAt(4) != '3') continue;
        if (s.charAt(6) != '4') continue;
        if (s.charAt(8) != '5') continue;
        if (s.charAt(10) != '6') continue;
        if (s.charAt(12) != '7') continue;
        if (s.charAt(14) != '8') continue;
        if (s.charAt(16) != '9') continue;
        if (s.charAt(18) != '0') continue;
        System.out.println(s);
    }
}