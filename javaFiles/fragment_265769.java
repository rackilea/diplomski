Object object = workers.get(0);
if(object instanceof LanguageTranslator) {
    LanguageTranslator lt = (LanguageTranslator) object;
    lt.setNumberOfLines(7);
}
else if(object instanceof Accountant) {
    Accountant acc = (Accountant) object;
    acc.doSomething();
}
etc...