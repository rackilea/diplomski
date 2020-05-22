package me.eckhart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

    protected Employee projectManagerIt;

    @Before
    public void setUp() throws Exception {

        Employee webDevSr = new Developer();
        webDevSr.setName("Jane").addProgrammingLanguage(ProgrammingLanguages.JAVASCRIPT).addProgrammingLanguage(ProgrammingLanguages.PYTHON).setWorkload(10);
        Employee webDevJr = new Developer();
        webDevJr.setName("Alex").addProgrammingLanguage(ProgrammingLanguages.PHP).setWorkload(15);
        Employee projectManagerWebDev = new ProjectManager();
        projectManagerWebDev.setName("James").addEmployee(webDevSr).addEmployee(webDevJr);

        Employee softwareDevSr = new Developer();
        softwareDevSr.setName("Martin").addProgrammingLanguage(ProgrammingLanguages.C).addProgrammingLanguage(ProgrammingLanguages.JAVA).setWorkload(35);
        Employee softwareDevJr = new Developer();
        softwareDevJr.setName("John").addProgrammingLanguage(ProgrammingLanguages.JAVA).setWorkload(30);
        Employee projectManagerBackend = new ProjectManager();
        projectManagerBackend.setName("Tom").addEmployee(softwareDevSr).addEmployee(softwareDevJr);

        Employee freelanceSoftwareDev = new Developer();
        freelanceSoftwareDev.setName("Marco").addProgrammingLanguage(ProgrammingLanguages.JAVA).addProgrammingLanguage(ProgrammingLanguages.PYTHON).addProgrammingLanguage(ProgrammingLanguages.C).setWorkload(25);
        Employee freelanceWebDev = new Developer();
        freelanceWebDev.setName("Claudio").addProgrammingLanguage(ProgrammingLanguages.SWIFT).addProgrammingLanguage(ProgrammingLanguages.JAVASCRIPT).addProgrammingLanguage(ProgrammingLanguages.PHP).setWorkload(10);
        Employee freelanceProjectManager = new ProjectManager();
        freelanceProjectManager.setName("Angie").addEmployee(freelanceSoftwareDev).addEmployee(freelanceWebDev);

        projectManagerIt = new ProjectManager();
        projectManagerIt.setName("Peter").addEmployee(projectManagerWebDev).addEmployee(projectManagerBackend).addEmployee(freelanceProjectManager);

    }

    @Test
    public void testComposite() throws Exception {

        Assert.assertEquals(90, projectManagerIt.getWorkload(ProgrammingLanguages.JAVA));
        Assert.assertEquals(20, projectManagerIt.getWorkload(ProgrammingLanguages.JAVASCRIPT));
        Assert.assertEquals(60, projectManagerIt.getWorkload(ProgrammingLanguages.C));
        Assert.assertEquals(25, projectManagerIt.getWorkload(ProgrammingLanguages.PHP));
        Assert.assertEquals(10, projectManagerIt.getWorkload(ProgrammingLanguages.SWIFT));
        Assert.assertEquals(35, projectManagerIt.getWorkload(ProgrammingLanguages.PYTHON));

    }
}