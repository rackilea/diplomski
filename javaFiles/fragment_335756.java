package test;

import test.StepOne.StepThree;
import test.StepOne.StepTwo;
import test.StepOne.LastStep;

public class TestBuilder {

    public static void main(String[] args) {

        String person1 = PersonBuilder.newInstance().head("head").body("body").arm("arm").leg("leg").build();

        String person2 = PersonBuilder.newInstance().head("head").body("body").arm("arm").build();

    }

}

interface StepOne {

    // mandatory
    StepTwo head(String head);

    interface StepTwo {
        // mandatory
        StepThree body(String body);
    }

    interface StepThree {
        // mandatory
        LastStep arm(String arm);
    }

    // all methods in this interface are not mandatory
    interface LastStep {
        LastStep leg(String leg);
        String build();
    }

}

class PersonBuilder implements StepOne, StepTwo, StepThree, LastStep {

    String head;
    String body;
    String arm;
    String leg;

    static StepOne newInstance() {
        return new PersonBuilder();
    }

    private PersonBuilder() {
    }



    public StepTwo head(String head) {
        this.head = head;
        return this;
    }

    public LastStep arm(String arm) {
        this.arm = arm;
        return this;
    }

    public StepThree body(String body) {
        this.body = body;
        return this;
    }

    public LastStep leg(String leg) {
        this.leg = leg;
        return this;
    }

    public String build() {
        return head + body + arm + leg;
    }
}