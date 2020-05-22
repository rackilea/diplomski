class FileClassTest extends Specification {

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

    def mockFile = new MockFor(File)

    //This is how i can verify that the write method was called 4 times(no more, no less)
    // but im not using Spock and some of the advanced verification abilites that come with it...
    mockFile.demand.write(4) {}

    def mockFileFactory = new MockFor(FileFactory)
    mockFileFactory.demand.makeFile(4) {new File(".")}    //Fixed.

    when:
    mockFile.use {
      mockFileFactory.use {
        fileClass.createFilePerObject()
      }
    }
    then:
//    1 * mockFile.write(_)

    //Just pass... Verification is done by MockFor, not Spock
    true
  }
}