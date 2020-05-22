package com.johanw.stackoverflow.dynamicinit;

public class PopulateObjects1 {

    interface InitialiseFieldAction {
        void initialise(MyObjectImpl object, String value);
    }

    private static InitialiseFieldAction[] initActions = new InitialiseFieldAction[] {
            new InitialiseFieldAction() { public void initialise(MyObjectImpl o, String value) { o.setName(value);} },
            new InitialiseFieldAction() { public void initialise(MyObjectImpl o, String value) { o.setStreet(value);} },
            new InitialiseFieldAction() { public void initialise(MyObjectImpl o, String value) { o.setNumber(Integer.valueOf(value));} },
    };

    public static MyObjectImpl retrieveWithValues(String[] values) {
        if (values.length != initActions.length) return null;   // Handle the fact you don't have the same amount of initialisations as the amount of fields
        MyObjectImpl o = new MyObjectImpl();
        for (int i = 0; i < initActions.length; i++) {
            initActions[i].initialise(o, values[i]);
        }
        return o;
    }
}