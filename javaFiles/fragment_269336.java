package org.acme.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnvGreetingService {

    private final String varA;

    @ConfigProperty(name = "ENV_VAR_B")
    String varB;

    public EnvGreetingService(@ConfigProperty(name = "ENV_VAR_A") String varA) {
        System.out.println("constructor varA=" + varA);
        System.out.println("constructor varB=" + varB);
        this.varA = varA;
    }

    public void greetWithEnvVar() {
        System.out.println("method varA=" + varA);
        System.out.println("method varB=" + varB);
    }
}