public class Menu {
public final static Menu MENU = new Menu();
private List<WeeklyMenu> weeklyMenu = new ArrayList<WeeklyMenu>();

private Menu(){
    weeklyMenu.add(new WeeklyMenu(false, "10:00 to 10:30", "Food1", "Food2", "Food3", "Food4", "Food5", "Food6", "Food7"));
    weeklyMenu.add(new WeeklyMenu(false, "10:30 to 11:00", "Food1", "Food2", "Food3", "Food4", "Food5", "Food6", "Food7"));
    weeklyMenu.add(new WeeklyMenu(false, "11:00 to 11:30", "Food1", "Food2", "Food3", "Food4", "Food5", "Food6", "Food7"));
    weeklyMenu.add(new WeeklyMenu(false, "11:30 to 12:00", "Food1", "Food2", "Food3", "Food4", "Food5", "Food6", "Food7"));
}

public List<WeeklyMenu> getWeeklyMenu() {
    return weeklyMenu;
}