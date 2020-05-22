// create new buffered reader
         BufferedReader br = new BufferedReader(new FileReader("file.txt"));

         // reads and prints BufferedReader
         System.out.println((char)br.read());
         System.out.println((char)br.read());

         // mark invoked at this position
         br.mark(26);
         System.out.println("mark() invoked");
         System.out.println((char)br.read());
         System.out.println((char)br.read());

         // reset() repositioned the stream to the mark
         br.reset();
         System.out.println("reset() invoked");
         System.out.println((char)br.read());
         System.out.println((char)br.read());