package com.PTS42.planner;

import java.io.Serializable;
import java.util.Date
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@WebService
@Entity @Table(name="Reserveringen")
public class Reservering implements Serializable {

    @Id @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date vanaf;

    @Temporal(TemporalType.TIMESTAMP)
    private Date tot;

    @ManyToOne
    @Embedded
    private Klant klant;

    @ManyToOne
    @Embedded
    private Machine machine;

    public int getId() {
        return id;
    }

    public void setId(@WebParam(name="reservering_id")int id) {
        this.id = id;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(@WebParam(name="reservering_klant")Klant klant) {
        this.klant = klant;
    }

    public Date getTot() {
        return tot;
    }

    public void setTot(@WebParam(name="reservering_tot")Date tot) {
        //int tempint = tot.getMonth();
        //tot.setMonth(tempint-1);
        this.tot = tot;
    }

    public Date getVanaf() {
        return vanaf;
    }

    public void setVanaf(@WebParam(name="reservering_vanaf")Date vanaf) {
        //int tempint = vanaf.getMonth();
        //vanaf.setMonth(tempint-1);
        this.vanaf = vanaf;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(@WebParam(name="reservering_machine")Machine machine) {
        this.machine = machine;
    }

    public Reservering() {
    }

    public Reservering(@WebParam(name="reservering_constructor_vanaf") Date vanaf, @WebParam(name="reservering_constructor_tot")Date tot, @WebParam(name="reservering_constructor_klant")Klant klant, @WebParam(name="reservering_constructor_machine")Machine machine)
    {

        this.vanaf = vanaf;
        this.tot = tot;
        this.klant = klant;
        this.machine = machine;
    }
}