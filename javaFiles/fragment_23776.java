//method count array
public static void rf (String[] songname, String[] songpath, String[] artist, String[] genre, int[] count, String file) throws FileNotFoundException, IOException
{
    BufferedReader reader = new BufferedReader (new FileReader (file));

    String temp, line = null;

    while ((line = reader.readLine ()) != null)
    {
        songname [count [0]] = line;
        songpath [count [0]] = reader.readLine ();
        artist [count [0]] = reader.readLine ();
        genre [count [0]] = reader.readLine ();
        count [0]++;
    }


    reader.close ();
}

//overloaded six parameter method
//without count array. count variable
public static void rf (String[] songname, String[] songpath, String[] genre, int count, String file) throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader (new FileReader (file));

        String temp, line = null;

        while ((line = reader.readLine ()) != null)
        {
            songname [count [0]] = line;
            songpath [count [0]] = reader.readLine ();
            artist [count [0]] = reader.readLine (); - remove this line
            genre [count] = reader.readLine ();//change this too, genre [count[0]]
            count++;//since this is not a array change to count[0]++.
        }


        reader.close ();
    }