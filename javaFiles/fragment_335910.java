public abstract class Player {

    private double attackPower;
    private double defensePower;

    // **** get rid of this and make it a calculated property
    // private double generalPower;

    public double getGeneralPower() {
        return 100 * getAttackPower() + getDefensePower();
    }