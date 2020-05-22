public static void PrintLines(string filepath,string key)
    {
        int counter = 1;
        string line;

        // Read the file and display it line by line.
        System.IO.StreamReader file = new System.IO.StreamReader(filepath);
        while ((line = file.ReadLine()) != null)
        {
            if (line.Contains(key))
            {
                Console.WriteLine("\t"+counter.ToString() + ": " + line);
            }
            counter++;
        }
        file.Close();
    }