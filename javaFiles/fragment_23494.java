val oldFile="steam_out_scala.txt"
val noDupFile="nodup_steam_out.txt"

import scala.io.Source
import java.io.{FileReader, FileNotFoundException, IOException}
import java.io.FileWriter;
import scala.collection.mutable.ListBuffer

var numbers = new ListBuffer[String]()
val fw = new FileWriter(noDupFile, true) 

for (line <- Source.fromFile(oldFile).getLines()) {
    if(Source.fromFile(noDupFile).getLines().forall(!_.equals(line))) {
        fw.write(line)
    }
}

fw.close()