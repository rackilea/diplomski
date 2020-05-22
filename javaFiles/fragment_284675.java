byte[] buffer = new byte[1024];
FileInputStream in = new FileInputStream("input.txt");
int rc = -1;
while ((rc = in.read(buffer)) != -1) {
    System.out.print(new String(buffer, 0, rc));
}