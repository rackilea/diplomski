public static Map<String, Map<String, Integer>> myDataSet =
        new LinkedHashMap<String, Map<String, Integer>>() {{
    this.put("My First Label", new LinkedHashMap<String, Integer>() {{
        this.put("Sub label 1", 500);
        this.put("Sub label 2", 1500);
    }});
    this.put("My Second Label", new LinkedHashMap<String, Integer>() {{
        this.put("Sub label 1", 2500);
    }});
}};