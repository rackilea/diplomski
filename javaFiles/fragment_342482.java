package com.example;
import com.google.inject.AbstractModule;
import play.libs.akka.AkkaGuiceSupport;

public class MyModule extends AbstractModule implements AkkaGuiceSupport {
    @Override
    protected void configure() {
        bindActor(UpdateDbActor.class, "update-db-actor");
        bind(SchedulingTask.class).asEagerSingleton();
    }
}