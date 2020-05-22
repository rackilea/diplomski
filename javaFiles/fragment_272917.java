import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
....
public static void main(String[] args) {

....

Type collectionType = new TypeToken<int[]>(){}.getType();

int[] festmengeNew1 = gson.fromJson(args[0], collectionType); 
int[] festmengeNew2 = gson.fromJson(args[1], collectionType); 
int[] festmengeNew3 = gson.fromJson(args[2], collectionType); 
....
}