//INSTANTIATE requestPart
...
SendSmsInput.TORECEIVERS receivers = new SendSmsInput.TORECEIVERS();
receivers.getMsisdn().add("value1");
receivers.getMsisdn().add("value2");
..
requestPart.setTORECEIVERS(receivers);