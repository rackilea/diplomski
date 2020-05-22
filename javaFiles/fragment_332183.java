package com.example.model;

import org.bson.types.ObjectId;

/**
 * Class representing an order item.
 */
public class Item
{
    private ObjectId id;
    private String name;

    /**
     * Constructor.
     */
    public Item() {
        //
    }

    /**
     * Sets the id of the Item.
     * @param id The new id of the Item.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Gets the id of the Item.
     * @return The id of the Item.
     */
    public ObjectId getId() {
        return this.id;
    }

    /**
     * Sets the name of the Item.
     * @param name The new name of the Item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the Item.
     * @return The name of the Item.
     */
    public String getName() {
        return this.name;
    }
}