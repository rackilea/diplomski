public int parseHex(String hex) {
    try {
        return Integer.parseInt(hex, 16);
    } catch (NumberFormatException e) {
        return 0;
    }
}

// elsewhere...
final int intValue = parseHex(hex);