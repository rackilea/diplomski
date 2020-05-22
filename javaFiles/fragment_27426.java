PrintWriter first = new PrintWriter(System.out);
first.print("Hello");
first.flush();

PrintWriter second = new PrintWriter(System.out);
second.print("Bye");
second.flush();
first.close();
second.close();