class FileClassTest extends Specification {

  class FileCustomWrapper extends File {

    def FileCustomWrapper(String pathname) {
      super(pathname);
    }

    //Ovveride the DefaultGroovyMethods method, Spock can recognize it, its staticly written
    // , and ovveriden only for the use of mocking...

    def write(String s) {
      metaClass.write(s)
      //super.write(s)
    }
  }

  FileClass fileClass

  def "test simple object"() {

    def listObjects = []

    SimpleObject object1 = new SimpleObject(objectName: "First object", objectContent: "First object content")
    SimpleObject object2 = new SimpleObject(objectName: "Second object", objectContent: "Second object content")
    SimpleObject object3 = new SimpleObject(objectName: "Third object", objectContent: "Third object content")
    SimpleObject object4 = new SimpleObject(objectName: "Fourth object", objectContent: "Fourth object content")

    listObjects << object1
    listObjects << object2
    listObjects << object3
    listObjects << object4

    fileClass = new FileClass(listObjects: listObjects, basePath: ".")

    def mockFile = Mock(FileCustomWrapper)

    def mockFileFactory = new MockFor(FileFactory)
    mockFileFactory.demand.makeFile(4) {mockFile}     //Pass the Spock mock

    when:
    mockFileFactory.use {
      fileClass.createFilePerObject()
    }

    then:
    //You can use the verification...
    4 * mockFile.write(_)
  }
}