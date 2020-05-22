import better.files._

object Hello extends App {
    val subdirectory = file"/path/to/subdirectory"
    subDirectory.clear()

    val file1 = file"/path/to/file1.txt"
    file1.delete()
}