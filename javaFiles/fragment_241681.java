class Other{
    @OneToOne
    Employee employe;
}

class Employee {
    @OneToOne(mappedBy = "empolyee", cascade = CascadeType.SAVE_UPDATE)
    Other other;
}