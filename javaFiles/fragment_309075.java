import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class GsonCircularReference {

    public class Category {
        protected List<Category> childList;
        protected int id;
        protected String name;
        protected int applicationCount;

        public List<Category> getChildList() {
            return childList;
        }

        public void setChildList(final List<Category> childList) {
            this.childList = childList;
        }

        public int getId() {
            return id;
        }

        public void setId(final int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public int getApplicationCount() {
            return applicationCount;
        }

        public void setApplicationCount(final int applicationCount) {
            this.applicationCount = applicationCount;
        }

        @Override
        public String toString() {
            return "Category [category=" + childList + ", id=" + id + ", name=" + name + ", applicationCount="
                    + applicationCount + "]";
        }

    }

    public static void main(final String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        com.google.gson.Gson gson = new GsonBuilder().create();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(new File("/tmp/gson.txt")));
        Collection<Category> fromJson = gson.fromJson(reader, new TypeToken<Collection<Category>>() {}.getType());
        System.out.println(fromJson);
    }

}