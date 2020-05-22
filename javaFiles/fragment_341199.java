import spock.lang.Specification

class Spec extends Specification {

    def 'it works'() {
        given:
        def is = GroovyMock(InputStream)
        def file = Mock(GridFile)
        byte[] bytes = 'test data'.bytes

        when:
        new FileHolder(file: file).read()

        then:
        1 * file.getInputStream() >> is
        1 * is.getBytes() >> bytes
    }

    class FileHolder {
        GridFile file;

        def read() {
            file.getInputStream().getBytes()
        }
    }

    class GridFile {
        InputStream getInputStream() {
            null
        }
    }
}