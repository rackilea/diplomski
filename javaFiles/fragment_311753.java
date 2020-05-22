for (int j = 0; j < tds.size() - 1; j++) {
    if (grossRevenue.equals(tds.get(j).text()) {
        for (String value : tds.get(j + 1).text().split(",\\s*")) {
            System.out.println(Integer.parseInt(value.trim()));
        }
    }
}