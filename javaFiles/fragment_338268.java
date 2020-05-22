URLConnection conn = url.openConnection();
InputStream is = conn.getInputStream();
Scanner scan = new Scanner(is);
while (scan.hasNextLine()) {
    System.out.println(scan.nextLine());
}