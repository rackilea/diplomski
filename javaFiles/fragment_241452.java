trait Base {
    final String xmlRepresentation

    void setup(String xmlRep) {
        this.xmlRepresentation = xmlRep
    }

    String toString() {
        xmlRepresentation
    }

    String getValue() {
        xmlRepresentation
    }
} 

enum Location implements Base {
    CollegeCampus('College Campus'), HighSchool('High School'), Online('Online')
    Location(String xmlRep) { setup xmlRep }
}

enum InstructorType implements Base {
    CollegeFaculty('College Faculty'), HighSchoolFaculty('High School Faculty')
    InstructorType(String xmlRep) { setup xmlRep }
}

assert Location.HighSchool in Location
assert Location.Online.value == 'Online'
assert InstructorType.CollegeFaculty in InstructorType