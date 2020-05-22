Optional<Info> oInfo1 = Optional.ofNullable(info1);
oInfo1.map(Info::getId).ifPresent(billing::setSenderId);
oInfo1.map(Info::getPartyNumber).ifPresent(billing::setSenderNumber);

Optional<Info> oInfo2 = Optional.ofNullable(info2);
oInfo2.map(Info::getId).ifPresent(billing::setReceiverId);
oInfo2.map(Info::getPartyNumber).ifPresent(billing::setSellerNumber);