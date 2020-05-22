public class mainMenu implements Scene {

    private Hero hero;
    private Enemy enemy;
    private MenuButtons mainMenuButtons;
    private Background background;

    public mainMenu setHero(Hero hero){this.hero = hero; return this}
    public mainMenu setEnemy(Enemy enemy){this.enemy = enemy; return this}
    public mainMenu setMainMenuButtons(MenuButtons mainMenuButtons){this.mainMenuButtons = mainMenuButtons; return this}
    public mainMenu setBackground(Background background){this.background = background; return this}


}