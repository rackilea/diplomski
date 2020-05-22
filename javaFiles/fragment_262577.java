package de.scrum_master.stackoverflow;

import org.bouncycastle.cms.SignerInformation;

public class SignerInformationConsumer {
  public String interact(SignerInformation si) {
    return si.getDigestAlgOID();
  }
}