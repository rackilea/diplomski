OutboundErrorCaseData existingCaseDta = ErrorCaseDataRepository.findById(caseNumber).get();
    if (outboundErrorCaseVO.getChannel() != null) {
        existingCaseDta.setChannel(outboundErrorCaseVO.getChannel());
    }
ErrorCaseDataRepository.save(existingCaseDta);
    ModelMapper mm = new ModelMapper();
    return mm.map(existingCaseDta, StoredOutboundErrorCaseVO.class);