response.setContentType("application/pdf");
response.setHeader("Content-Disposition", "inline; filename=bill.pdf");
OutputStream out = response.getOutputStream(); 
try (FileInputStream in = new FileInputStream("D:\\Invoice\\Invoice_1094.pdf")) {
    int content;
    while ((content = in.read()) != -1) {
        out.write(content);
    }
} catch (IOException e) {
    e.printStackTrace();
}
out.close();