package de.scrum_master.stackoverflow.q55475971

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class EchoClientIT extends Specification {
  static final int SERVER_PORT = 4444

  @Shared
  EchoClient echoClient
  @Shared
  EchoServer echoServer

  void setupSpec() {
    echoServer = new EchoServer(SERVER_PORT)
    echoClient = new EchoClient("localhost", SERVER_PORT)
  }

  void cleanupSpec() {
    echoClient?.close()
    echoServer?.close()
  }

  @Unroll
  def "server echoes client message '#message'"() {
    expect:
    echoClient.sendMessage(message) == message.toString()

    where:
    message << ["echo", "Hello world!", null]
  }

  def "multiple echo clients"() {
    given:
    def echoClients = [
      new EchoClient("localhost", SERVER_PORT),
      new EchoClient("localhost", SERVER_PORT),
      new EchoClient("localhost", SERVER_PORT)
    ]

    expect:
    echoClients.each {
      assert it.sendMessage("foo") == "foo"
    }
    echoClients.each {
      assert it.sendMessage("bar") == "bar"
    }

    cleanup:
    echoClients.each { it.close() }
  }

  @Unroll
  def "client creation fails with #exceptionType.simpleName when using illegal #connectionInfo"() {
    when:
    new EchoClient(hostName, portNumber)

    then:
    thrown exceptionType

    where:
    connectionInfo | hostName         | portNumber      | exceptionType
    "host name"    | "does.not.exist" | SERVER_PORT     | UnknownHostException
    "port number"  | "localhost"      | SERVER_PORT + 1 | IOException
  }
}