public static void main(String args[]) throws IOException
    {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("ioreadver1ans.txt")));
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            //taking input
            String str1 = "Enter the Character:";
           // 
            System.out.println("Enter the String:");
            String str= br.readLine();
            System.out.println("Enter the Character: ");
            char ch =(char)br.read();

            pw.write(str1);
            pw.write(ch);
            pw.write("\n");
            pw.write(str);
            pw.flush();
            pw.close();
        }