InputStreamReader isr = new InputStreamReader(System.in); 
BufferedReader br = new BufferedReader (isr);
try {
a = Integer.parseInt(br.readLine());
} catch (IOException e) {
e.printStackTrace();
}