package com.springJPA.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springJPA.domain.Adresse;
import com.springJPA.domain.Utilisateur;
import com.springJPA.service.AdresseService;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Utilisateur utilisateur = new Utilisateur();

        //--------
        Adresse adresse = new Adresse();
        adresse.setRue("kantawi");
        adresse.setVille("Sousse");
        adresse.setPays("Tunisie");
        //--------

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        AdresseService adrService = (AdresseService) context.getBean("adrService");
        adrService.ajoutAdresse(adresse);
    }

}