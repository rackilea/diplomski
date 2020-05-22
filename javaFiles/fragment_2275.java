package de.scrum_master.aspect;

import de.scrum_master.app.Application;

public aspect ConstantChanger {
    Object around() : get(* Application.NAMES) {
        System.out.println(thisJoinPointStaticPart);
        return new String[] { "Hack1", "Hack2", "Hack3", "Hack4", "Hack5" };
    }
}