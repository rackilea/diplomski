@GetMapping("/download")
public ResponseEntity<String> handleDownload() throws Exception {
    Database db = new Database();
    List<String> usernames = db.getUsernames();
    StringBuilder buf = new StringBuilder();
    for (String username : usernames)
        buf.append(username).append("\r\n"); // or just "\n", your choice
    return ResponseEntity.ok()
            .header("Content-Disposition", "attachment; filename=\"usernames.txt\"")
            .contentType(MediaType.TEXT_PLAIN)
            .body(buf.toString());
}