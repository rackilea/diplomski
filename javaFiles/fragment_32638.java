.....
Process p = pb.start();

BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

String in;
while((in = input.readLine()) != null) {
    out.println(in);
}

int exitVal = p.waitFor();
.....