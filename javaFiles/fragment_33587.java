.<Admis, PreCandidat>chunk(100)
   .reader(readerDBAdmis())
   .processor(new AdmisItemProcessor(preCandidatRepository, scolFormationSpecialisationRepository, preCandidatureRepository))
   .writer(writerPGICocktail())
   .faultTolerant()
   .skip(AdmisSkipException.class)
   .skipLimit(SKIP_LIMIT) 
   .build();