from("direct:myFiles")
        .bean(SetSequenceNumber.class)  // set header "seqnum" of type Long
        .resequence(header("seqnum")).stream().timeout(5000).rejectOld()
        .process(new Processor() {
            Long lastSeq;
            @Override
            public void process(Exchange exchange) throws Exception {
                Long seqnum = exchange.getIn().getHeader("seqnum", Long.class);
                if (lastSeq == null) {
                    lastSeq = seqnum;
                } else {
                    if (seqnum != lastSeq + 1) {
                        throw new IllegalStateException("Skipped sequence number between " + lastSeq + " and " + seqnum);
                    }
                    lastSeq = seqnum;
                }
            }
        })
        .log("Resequenced: ${header.seqnum}")
;