@Bean
public FlatFileItemReader<OphthalmicLens> hoyaReader() {

   Locale locale = Locale.getDefault(); // set your locale
   DefaultFieldSetFactory fieldSetFactory = new DefaultFieldSetFactory();
   fieldSetFactory.setNumberFormat(NumberFormat.getInstance(locale));

   return new FlatFileItemReaderBuilder<OphthalmicLens>().name("ItemReader")
        .resource(new FileSystemResource(new File("C:\\\\sviluppo\\\\optix\\\\lenses\\\\hoya\\\\lenses.csv")))
        .delimited()
        .delimiter(";")
        .fieldSetFactory(fieldSetFactory)
        .names(new String[] { "BARCODE","LENTE","TRATTAMENTO","COLORE","SFERO","CILINDRO","RL","ADDIZIONE","DIAMETRO"})
        .linesToSkip(1)
        .lineMapper(new DefaultLineMapper<>())
        .fieldSetMapper(new HoyaOphthalmicLensMapper())
        .build();
    }
}