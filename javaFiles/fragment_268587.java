session.getTransaction().begin();
SuiteVersion suite = ... // retrieved in some way
ModuleVersion module = ... // retrieved in some way
suite.getModuleVersions().remove(module);
module.getSuiteVersions().remove(suite);
session.getTransaction().commit(); // the "association" record should get removed