public static void main(String[] args) throws Exception {
    JSONObject obj = new JSONObject();

    obj.put("Phone Number:","XXXXXXXXX");
    obj.put("Fname:","Mike");
    obj.put("Lname:","Miller");
    obj.put("Street:","101");
    FileWriter file = new FileWriter("D:\\file1.json");
    try {
        file.write(obj.toJSONString());
    }catch (Exception E) {
        E.printStackTrace();
    } finally {
        file.flush();
        file.close();
    }
}