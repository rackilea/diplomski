// Read titles from titlesfile.txt
public class ReadTitles {
    public static void main (Context context) {
        ToDoManagerSingleton tmp = ToDoManagerSingleton.getInstance();
        tmp.ReadTitlesFromFile(Context context);
    }
}