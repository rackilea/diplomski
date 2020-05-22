String path = System.getenv("APPDATA") + File.separator + "best_scores.txt";
try (BufferedWriter bw = new BufferedWriter(new FileWriter(path)))
{
    for(String s : rowsToSave) {
        bw.write(s);
    }
}
catch (Exception e)
{
        // ...
}