Map<String, Map<String, String>> getTableNames() {
    final Map<String, String> revenue = new LinkedHashMap<String, String>() {
        { put("Total Revenue", "totalRevenue"); }
        { put("Cost of Revenue", "costOfRevenue"); }
        { put("Gross Profit", "grossProfit"); }
    };
    final Map<String, String> operatingExpenses = new LinkedHashMap<String, String>() {
        { put("Research Development", "researchDevelopment"); }
        { put("Selling General and Administrative", "sellingGeneralAdministrative"); }
        { put("Non Recurring", "nonRecurring"); }
        { put("Others", "otherOperatingExpenses"); }
        { put("Total Operating Expenses", "totalOperatingExpenses"); }
        { put("Operating Income or Loss", "operatingIncome"); }
    };
    Map<String, Map<String, String>> allTableNames = new LinkedHashMap<String, Map<String, String>>() {
        { put("Revenue", revenue); }
        { put("Operating Expenses", operatingExpenses); }

    };
    return allTableNames;
}