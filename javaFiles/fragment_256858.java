final FileTemplateResolver templateResolverFile = new FileTemplateResolver();
templateResolverFile.setTemplateMode(TemplateMode.HTML);
templateResolverFile.setPrefix("src/main/resources/templates/html/");
templateResolverFile.setSuffix(".html");
templateResolverFile.setCacheTTLMs(1 * 60 * 60 * 1000l);
templateResolverFile.setCacheable(Boolean.TRUE);
templateResolverFile.setCharacterEncoding("UTF-8");
templateResolverFile.setCheckExistence(true);
templateResolverFile.setUseDecoupledLogic(true);
templateResolverFile.setCheckExistence(true);

final TemplateEngine templateEngine = new TemplateEngine();
templateEngine.setTemplateResolver(templateResolverFile);

final Context context01 = new Context();
context01.setVariable("products",ProductRepository.getInstance().findAll());

final BufferedWriter writer01=new BufferedWriter(new OutputStreamWriter(System.out));
templateEngine.process("LogicTemplate",context01,writer01);