@PostMapping("/download")
@ResponseBody
public String handleFileUpload(RedirectAttributes redirectAttributes) throws Exception {
    Database db = new Database();
    List<String> usernames = db.getUsernames();
    StringBuilder buf = new StringBuilder();
    for (String username : usernames)
        buf.append(username).append("\r\n"); // or just "\n", your choice
    return buf.toString();
}