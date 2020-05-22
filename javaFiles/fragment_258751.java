PrintWriter out = new PrintWriter("agentreport.txt");
try {
    // Existing code here
}
finally {
    // This closes the file and frees the descriptor, but also flushes the buffers
    out.close();
}