private static final Pattern COMMA = Pattern.compile(",");

String result = COMMA.splitAsStream("UC_Admin,Internal,UC_Reg,US_Admin")
    .filter(role -> role.contains("UC"))
    .map(String::trim)
    .collect(Collectors.joining(","));