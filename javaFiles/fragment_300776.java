package de.scrum_master.stackoverflow.q60143388

import spock.lang.Specification

class MessageServiceTest extends Specification {
  def "build request message"() {
    given:
    def id = "12345"
    MessageBuilder messageBuilder = Mock()
    MessageService messageService = new MessageService()
    messageService.messageBuilder = messageBuilder

    when:
    RequestMessage requestMessage = messageService.getMessage(id)

    then:
    1 * messageBuilder.buildNew(id) >> requestMessage
  }
}