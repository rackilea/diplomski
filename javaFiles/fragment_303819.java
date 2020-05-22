classToTest = new ClassToTest();
    template = mock(Template.class);
    classToTest.setTemplate(template);
    when(template.getTemplates()).thenReturn(templates);

    List<TemplateDto> result = classToTest.getTemplates("template1");