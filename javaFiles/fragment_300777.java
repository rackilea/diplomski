package de.scrum_master.stackoverflow.q60143388

import spock.lang.Specification

class MessageServiceTest extends Specification {
  def "build request message"() {
    given:
    def id = "12345"
    RequestMessage requestMessage = Mock()
    MessageBuilder messageBuilder = Mock()
    MessageService messageService = new MessageService()
    messageService.messageBuilder = messageBuilder

    when:
    RequestMessage result = messageService.getMessage(id)

    then:
    1 * messageBuilder.buildNew(id) >> requestMessage
    result.toString().startsWith("Mock for type 'RequestMessage'")
  }
}