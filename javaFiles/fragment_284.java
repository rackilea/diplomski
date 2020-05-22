import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.zip.GZIPInputStream
import org.apache.commons.io.input.CountingInputStream
import static java.nio.file.StandardWatchEventKinds.*

class LogReader
{
    private final Path dir = Paths.get('D:\\Projekte\\watcher_service\\data\\')
    private watcher
    private positionMap = [:]
    long lineCount = 0

    static void main(def args)
    {
        new LogReader().processEvents()
    }

    LogReader()
    {
        watcher = FileSystems.getDefault().newWatchService()
        dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY)
    }

    void processEvents()
    {
        def key = watcher.take()
        boolean doLeave = false

        while ((key != null) && (doLeave == false))
        {
            key.pollEvents().each { event ->
                def kind = event.kind()
                Path name = event.context()

                println "Event received $kind: $name"
                if (kind == ENTRY_MODIFY) {
                    // use position from the map, if entry is not there use default value 0
                    processChange(name, positionMap.get(name.toString(), 0))
                }
                else if (kind == ENTRY_CREATE) {
                    processChange(name, 0)
                }
                else {
                    doLeave = true
                    return
                }
            }
            key.reset()
            key = watcher.take()
        }
    }

    private void processChange(Path name, long position)
    {
        // open file and go to last position
        Path absolutePath = dir.resolve(name)
        def countingStream =
                new CountingInputStream(
                new GZIPInputStream(
                Files.newInputStream(absolutePath, StandardOpenOption.READ)))
        position = countingStream.skip(position)
        println "Moving to position $position"

        // processing each new line
        // at the first start all lines are read
        int newLineCount = 0
        countingStream.withReader('UTF-8') { reader ->
            reader.eachLine { line ->
                println "${++lineCount}: $line"
                ++newLineCount
            }
        }
        println "${++lineCount}: $newLineCount new lines +++Finished+++"

        // store new position in map
        positionMap[name.toString()] = countingStream.count
        println "Storing new position $countingStream.count"
        countingStream.close()
    }
}