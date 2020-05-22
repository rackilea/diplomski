package me.eckhart;

import java.util.ArrayList;
import java.util.List;

public class Developer extends Employee {

    private List<ProgrammingLanguages> languagesList = null;

    private int workload = 0;

    public Developer() {
        this.languagesList = new ArrayList<>();
    }

    @Override
    public Employee setLanguagesList(List<ProgrammingLanguages> languagesList) {
        this.languagesList = languagesList;
        return this;
    }

    @Override
    public Employee addProgrammingLanguage(ProgrammingLanguages language) {
        this.languagesList.add(language);
        return this;
    }

    @Override
    public List<ProgrammingLanguages> getLanguagesList() {
        return this.languagesList;
    }

    /* Composite operations. */

    public Employee setWorkload(int workload) {
        if (workload < -1) throw new IllegalArgumentException("Workload cannot be negative.");
        this.workload = workload;
        return this;
    }

    public int getWorkload(ProgrammingLanguages language) {
        if (this.languagesList.contains(language)) return workload;
        return 0;
    }

}