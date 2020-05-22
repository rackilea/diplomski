import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubWriter;
import android.app.Activity;
import android.os.Bundle;



public class EpubAppActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Book b =  new Book();
        b.getMetadata().addTitle("test epub book");
        b.getMetadata().addAuthor(new Author("author name"));

       EpubWriter w = new EpubWriter();

        FileOutputStream fos;
        try {

            File file = new File(getApplicationContext().getExternalFilesDir(null), "test.epub");
            if(!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            w.write(b, fos);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}