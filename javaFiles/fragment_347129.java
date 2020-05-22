public class ObjectInitialize(){
Country france,russia,austria,prussia;
...

public void objectInitialize(){
    france = new Country("France", 10, 200, 2, 100, 100, 1, 1, 800);
    russia = new Country("Russia", 8, 150, 1, 100, 100, 1, 1, 1300);
    austria = new Country("Austria", 8, 150, 1, 100, 100, 1, 1, 700);
    prussia = new Country("Prussia", 8, 175, 2, 100, 100, 1, 1, 700);
    FranceUI franceUI = new FranceUI();
    RussiaUI russiaUI = new RussiaUI();
    AustriaUI austriaUI = new AustriaUI();
    PrussiaUI prussiaUI = new PrussiaUI();
    EventHandlerUI eventHandlerUI = new EventHandlerUI();
    GameStartUI gameStartUI = new GameStartUI();
    AllianceUI allianceUI = new AllianceUI();
    Utilities util = new Utilities();
}
...
}