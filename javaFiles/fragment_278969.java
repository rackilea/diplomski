import javax.naming.StringRefAddr;

/**
 * Created by Makoto on 2/4/2016.
 */

public class Temperature {
    public double temp;
    public char type;

    Temperature() {
        temp = 0.0;
        type = 'o';

    }

    Temperature( double temperature, char tempType){
            temperature = temp;
            tempType = type;
    }

    public Temperature toFahrenheit() {
        type.equalsIgnoreCase();
        switch (type) {
            case 'C':

                break;

            case 'K':

                break;

            default:
                System.out.println("Can not convert.");
                break;
        }

        return this;
    }

    public Temperature toCelsius() {
        type.equalsIgnoreCase();
        switch (type) {
            case 'F':

                break;

            case 'K':

                break;

            default:
                System.out.println("Can not convert.");
                break;
        }

        return this;
    }

    public Temperature toKelvin() {
        type.equalsIgnoreCase();
        switch (type) {
            case 'C':

                break;

            case 'F':

                break;

            default:
                System.out.println("Can not convert.");
                break;
        }

        return this;
    }

    public Temperature add(Temperature x){

        this.temp + x.temp;
        return this;
    }

    public Temperature subtract(Temperature x){

        this.temp = this.temp - x.temp;
        return this;
    }
    public Temperature divide(int x){

        this.temp = /x;
        return this;
    }

}