package de.scrum_master.stackoverflow.q55475971

import spock.lang.Specification
import spock.lang.Unroll

class EchoClientIT extends Specification {
  static final int SERVER_PORT = 4444
  static Thread echoServerThread
  static EchoClient echoClient

  void setupSpec() {
    echoServerThread = Thread.start {
      new EchoServer().start(SERVER_PORT)
    }
    echoClient = new EchoClient()
    echoClient.startConnection("localhost", SERVER_PORT)
  }

  void cleanupSpec() {
    echoServerThread?.stop()
  }

  @Unroll
  def "server echoes client message '#message'"() {
    expect:
    echoClient.sendMessage(message) == message.toString()

    where:
    message << ["echo", "Hello world!", null]
  }
}