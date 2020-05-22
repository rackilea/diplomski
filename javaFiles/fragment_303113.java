private void writeStringToTextFile(String s, String f) {

    File sdCard = Environment.getExternalStorageDirectory();
    File dir = new File(sdCard.getAbsolutePath());
    dir.mkdirs();

    File file = new File(dir, f);
    try
    {
        FileOutputStream f1 = new FileOutputStream(file, false);
        PrintStream p = new PrintStream(f1);
        p.print(s);
        p.close();
        f1.close();
    } catch (FileNotFoundException e)
    {
    } catch (IOException e)
    {
    }
    }
    }