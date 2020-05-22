package com.example.model;

import java.util.ArrayList;
import org.bson.types.ObjectId;

/**
 * Class representing an Order.
 */
public class Order
{
    private ObjectId id;
    private ArrayList<Item> items;

    /**
     * Default constructor. Needed for testing.
     */
    public Order() {
        this.items = new ArrayList<>();
    }

    /**
     * Sets the id of the Order.
     * @param id The new id of the Order.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Gets the id of the Order.
     * @return The id of the Order.
     */
    public ObjectId getId() {
        return this.id;
    }

    /**
     * Sets the items for the Order.
     * @param items The items for the Order.
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Gets the items for the Order.
     * @return The items for the Order.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Adds an item to the Order.
     * @param item The new Item to add to the Order.
     */
    public void addItem(Item item) {
        this.items.add(item);
    }
}