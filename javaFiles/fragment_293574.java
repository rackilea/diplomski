package com.zack.music.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

@Entity(name="COMPOSER")
public class Composer implements Serializable {

    @Id
    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="BIRTH", nullable = false)
    private Date birth;

    @Column(name="DEATH", nullable = true)
    private Date death;

    @ElementCollection
    @CollectionTable(
            name="COMPOSITION",
            joinColumns=@JoinColumn(name="COMPOSER", referencedColumnName="NAME")
    )
    @Column(name="NAME")
    private List<String> compositions;

    protected Composer() { }

    public Composer(String name, Date birth, Date death) {
        this.name = name;
        this.birth = birth;
        this.death = death;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDeath() {
        return death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }

    public List<String> getCompositions() {
        return compositions;
    }
}

@Entity(name="COMPOSITION")
public class Composition implements Serializable {

    @Id
    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="COMPOSER", nullable = false)
    private String composer;

    protected Composition() { }

    public Composition(String name, String composer) {
        this.name = name;
        this.composer = composer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }
}