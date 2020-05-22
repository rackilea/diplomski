package de.scrum_master.stackoverflow

import org.bouncycastle.cms.SignerInformation
import spock.lang.Specification

class SignerInformationConsumerTest extends Specification {

  static class SignerInformationMock extends SignerInformation {
    protected SignerInformationMock(SignerInformation baseInfo) {
      super(baseInfo)
    }
  }

  //SignerInformation signerInformation = Spy(SignerInformationMock, useObjenesis: true)
  SignerInformation signerInformation = Mock(SignerInformationMock)

  def "should return valid array"() {
    given:
    SignerInformationConsumer signerInformationConsumer = new SignerInformationConsumer()
    signerInformation.getDigestAlgOID() >> "aaa"
    expect:
    signerInformationConsumer.interact(signerInformation) == "aaa"
  }
}