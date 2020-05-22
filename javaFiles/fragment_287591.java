package com.springJPA.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Adresse
 *
 */
@Entity

public class Adresse implements Serializable {


    private int id_adresse;
    private String rue;
    private String ville;
    private String pays;
    private static final long serialVersionUID = 1L;

    public Adresse() {
        super();
    }   
    @Id  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence_adresse")
    @SequenceGenerator(name = "id_Sequence_adresse", sequenceName = "ID_SEQ_ADRESSE")
    public int getId_adresse() {
        return this.id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }   
    public String getRue() {
        return this.rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }   
    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }   
    public String getPays() {
        return this.pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

}