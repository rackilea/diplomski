package de.scrum_master.stackoverflow.q55475971

import spock.lang.Specification
import spock.lang.Unroll

class EchoClientTest extends Specification {
  @Unroll
  def "server echoes client message '#message'"() {
    given:
    def outputStream = new PipedOutputStream()
    def inputStream = new PipedInputStream(outputStream)
    def echoClient = new EchoClient(
      Stub(Socket) {
        getOutputStream() >> outputStream
        getInputStream() >> inputStream
      }
    )

    expect:
    echoClient.sendMessage(message) == message.toString()

    cleanup:
    echoClient.close()

    where:
    message << ["echo", "Hello world!", null]
  }

  def "client creation fails for unreadable socket streams"() {
    when:
    new EchoClient(
      Stub(Socket) {
        getOutputStream() >> { throw new IOException("cannot read output stream") }
        getInputStream() >> { throw new IOException("cannot read input stream") }
      }
    )

    then:
    thrown IOException
  }

  def "client creation fails for unknown host name"() {
    when:
    new EchoClient("does.not.exist", 4444)

    then:
    thrown IOException
  }
}