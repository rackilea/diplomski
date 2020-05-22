package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Bean implements Serializable {

    private List<Item> list;
    private Item item = new Item();
    private boolean edit;

    @PostConstruct
    public void init() {
        // list = dao.list();
        // Actually, you should retrieve the list from DAO. This is just for demo.
        list = new ArrayList<Item>();
        list.add(new Item(1L, "item1"));
        list.add(new Item(2L, "item2"));
        list.add(new Item(3L, "item3"));
    }

    public void add() {
        // dao.create(item);
        // Actually, the DAO should already have set the ID from DB. This is just for demo.
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
        item = new Item(); // Reset placeholder.
    }

    public void edit(Item item) {
        this.item = item;
        edit = true;
    }

    public void save() {
        // dao.update(item);
        item = new Item(); // Reset placeholder.
        edit = false;
    }

    public void delete(Item item) {
        // dao.delete(item);
        list.remove(item);
    }

    public List<Item> getList() {
        return list;
    }

    public Item getItem() {
        return item;
    }

    public boolean isEdit() {
        return edit;
    }

    // Other getters/setters are actually unnecessary. Feel free to add them though.

}