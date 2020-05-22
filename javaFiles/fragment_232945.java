package smb4jackcess;

import java.nio.channels.FileChannel;

import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Database.FileFormat;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.IndexBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;

public class Smb4jackcessMain {

    public static void main(String[] args) {

        String smbURL = "smb://gord:mypassword@SERVERNAME/sharename/etc/newdb.accdb";
        try (SmbFileChannel sfc = new SmbFileChannel(smbURL)) {

            // create a brand new database file                
            Database db = new DatabaseBuilder()
                    .setChannel(sfc)
                    .setFileFormat(FileFormat.V2010)
                    .create();

            // add a table to it
            Table newTable = new TableBuilder("NewTable")
                    .addColumn(new ColumnBuilder("ID", DataType.LONG)
                            .setAutoNumber(true))
                    .addColumn(new ColumnBuilder("TextField", DataType.TEXT))
                    .addIndex(new IndexBuilder(IndexBuilder.PRIMARY_KEY_NAME)
                            .addColumns("ID").setPrimaryKey())
                    .toTable(db);

            // insert a row into the table
            newTable.addRow(Column.AUTO_NUMBER, "This is a new row.");

            db.close();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }

}