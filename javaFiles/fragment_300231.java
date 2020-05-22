byte[] inputBytes = "line 1\nline 2\nline 3\ntok 1 tok 2".getBytes();
Reader r = new InputStreamReader(new ByteArrayInputStream(inputBytes));

BufferedReader br = new BufferedReader(r);
Scanner s = new Scanner(br);

System.out.println("First line:  " + br.readLine());
System.out.println("Second line: " + br.readLine());
System.out.println("Third line:  " + br.readLine());

System.out.println("Remaining tokens:");
while (s.hasNext())
    System.out.println(s.next());