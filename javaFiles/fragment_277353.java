Site site = siteRepository.findOne(1L);

Sequence seq = new Sequence();
seq.setSite(site);
site.getSequences().add(seq);

sequenceRepository.save(seq);