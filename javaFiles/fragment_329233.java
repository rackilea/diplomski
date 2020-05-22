Process process = new ProcessBuilder("sh", "-c", "time curl -s 'http://www.google.com/'").start();
InputStream in = process.getInputStream();
int i;
while (-1 != (i = in.read())){
    System.out.write(i);
}