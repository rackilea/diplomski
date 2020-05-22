import java.io.File;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class myClass 
{
    private Context c = null;
    private SQLiteDatabase mDb;

    public myClass(Context c)
    {
        // Constructor 
        this.c = c;
        mDb = SQLiteDatabase.openDatabase(ClubCP.DbPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    public String getInformationData(String mySQL)
    {
        String information_text = null;

        try
        {
            Cursor information = mDb.rawQuery(mySQL,null);
            int information1 = information.getColumnIndex("description");
            while (information.moveToNext()) 
            {
                String columns = (String) information.getString(information1);
                information_text =  "<head><style>@font-face {font-family: 'verdana';src: url('file://"+ ClubCP.SDcardPath+ "Homa.ttf');}body {font-family: 'verdana';color:#ffffff;font-size:18px;padding:10px 10px 0 10px;}</style></head>"+"<html Content-Type: text/html charset=UTF-8;dir=\"rtl\"><body>"
                        + "<p dir=\"rtl\"  align=\"justify\">"                
                      + columns
                       + "</p> "
                      + "</body></html>";
            }
        } 
        catch (Exception e) 
        {
            Toast.makeText(c, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return information_text;
    }

    public void Change_header(View v, String id)
    {
       String path = ClubCP.SDcardPath + "/temp/"+id+"-header.jpg"; 
       Log.i("view binder", path);
       File imgFile = new File(path);
       ImageView img = (ImageView) v;

       if(imgFile.exists())
       {
           Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());                         
           img.setImageBitmap(myBitmap);
       }
       else               
         img.setImageDrawable(c.getResources().getDrawable(R.drawable.music_album_header_vinyl));
    }

    public void closeMyDb()
    {
        if (mDb != null)
            mDb.close();
        else
            throw new NullPointerException("No database selected!");
    }
}