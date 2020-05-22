try (PrintWriter out = new PrintWriter("output.txt"))
        {

            out.print("hello");
        }
        catch (FileNotFoundException e)
        {
            System.out.print("file not found");
            e.printStackTrace();
        }