BufferedReader in = new BufferedReader(new FileReader("file.in"));
BufferedWriter out = new BufferedWriter(new FileWriter("file.out"));

String line = in.readLine(); // <-- read whole line
StringTokenizer tk = new StringTokenizer(line);
int a = Integer.parseInt(tk.nextToken()); // <-- read single word on line and parse to int

out.write(""+a);
out.flush();