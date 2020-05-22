package com.test;

import javax.swing.AbstractSpinnerModel;
import javax.swing.JSpinner;

public class TimeSpinner extends JSpinner {

    public TimeSpinner() {
        super();
        setModel(new TimeSpinnerModel());
        ((JSpinner.DefaultEditor) getEditor()).getTextField().setEditable(true);
    }

    public class TimeSpinnerModel extends AbstractSpinnerModel {

        private Time t = new Time(0);

        @Override
        public Object getValue() {
            return t;
        }

        @Override
        public void setValue(Object o) {
            try {
                t.set(Time.parseTime(o.toString()));
                fireStateChanged();
            } catch (NumberFormatException e) {}
        }

        @Override
        public Object getNextValue() {
            // next 10 seconds step
            return new Time(((t.getSeconds() + 10) / 10) * 10);
        }

        @Override
        public Object getPreviousValue() {
            if (t.getSeconds() > 0) {
                // previous 10 seconds step
                return new Time(((t.getSeconds() - 1) / 10) * 10);
            }
            return t;
        }
    }
}