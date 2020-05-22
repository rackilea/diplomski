package com.mysite.client;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public enum AnEnum implements Serializable, IsSerializable {

    ITEM_A("Item a description"), ITEM_B("Item b description");

    private String description;

    AnEnum() {
    }

    AnEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}