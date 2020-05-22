function Role(roleId, roleName) {
    this.id = roleId;
    this.roleName = roleName;
    Role.roles[roleId] = this;
}
Role.roles = {};

function Employee(employeeId, employeeName, roleId) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.roleId = roleId;
}
Employee.prototype = Object.create(null, {
    role: {
        configurable: true,
        enumerable: true,
        get: function () {return Role.roles[this.roleId];},
        set: function (role) {return Role.roles[this.roleId = role.id]}
    }
});

var man   = new Role(0, 'Romeo'),
    woman = new Role(1, 'Juliet');
var actor   = new Employee(0, 'John Smith', 0),
    actress = new Employee(1, 'Jane Doe', 1);

actor;      // Employee {employeeId: 0, employeeName: "John Smith", roleId: 0}
actor.role; // Role {id: 0, roleName: "Romeo"} === Role.roles[0];