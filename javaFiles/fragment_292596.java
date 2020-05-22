package de.scrum_master.aspect;

import de.scrum_master.app.Application;

public aspect CheckBounds {
    pointcut factorialCall() :
        call(int Application.factorial*(int));

    pointcut initialFactorialCall(int i) :
        factorialCall() &&
        !cflowbelow(factorialCall()) &&
        args(i);

    pointcut initialFactorialCall2(int i) :
        factorialCall() &&
        !withincode(int Application.factorial*(int)) &&
        args(i);

    before(int i) : initialFactorialCall(i) {
        if (i < 1 || i == 10) {
            System.out.println(new IllegalArgumentException("x must be >=1 and != 10"));
        }
    }
}