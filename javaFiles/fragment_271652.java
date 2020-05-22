public static void main(String[] args) throws IOException, JSONException {

    ProcessBuilder pb = new ProcessBuilder("/test.sh");
    Process p = pb.start();
    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line = null;

    // Initialize 2 JSON Objects
    JSONObject networkMetrics = new JSONObject();
    JSONObject osMetrics = new JSONObject();

    while ((line = reader.readLine()) != null)
    {
        JSONObject jSONObject = new JSONObject(line);

        System.out.println("Parsed JSON : " + jSONObject);

        // Get the JSON Objects if they exist
        if (jSONObject.has("network-metrics")) {
             networkMetrics = jSONObject.getJSONObject("network-metrics");
             System.out.println("Network Metrics JSON : " + networkMetrics);
        }
        if (jSONObject.has("os-metrics")) {
             osMetrics = jSONObject.getJSONObject("os-metrics");
             System.out.println("OS Metrics JSON : " + osMetrics);
        }   
    }
}