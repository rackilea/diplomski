public class Temperature {

    private float degrees;
    char scale;


    public Temperature(){
        degrees = 0;
        scale = 'C';
    }
    public Temperature(float degrees){
        this.degrees = degrees;
        scale = 'C';
    }

    public Temperature(char scale){
        // change the given scale to uppercase
        scale = Character.toUpperCase(scale);
        this.scale = 'C';
        // if the given scale is 'F' then change the instance variable scale (this.scale) to scale passed in parameter
        if(scale == 'F'){
            this.scale = scale;
        }
        this.degrees = 0;

    }
    public Temperature(float degrees, char scale){
        scale = Character.toUpperCase(scale);
        this.scale = 'C';
        if(scale == 'F'){
            this.scale = scale;
        }
        //set instance variable degrees (this.degrees) to the degrees passed in parameter
        this.degrees = degrees;  
    }

    public float getTempCels (float degrees, char scale){
        scale = Character.toUpperCase(scale);

        // if the given scale is celsius then just return whatever was passed in parameter
        if(scale == 'C'){
            return degrees;
        }

        // else if the given scale is fahrenheit then use the formula to convert to celsius and return the result
        else if(scale == 'F'){
            return ((degrees - 32.0f) * (5.0f/9.0f));
        }

        // if the given scale is anything else than celsius or fahrenheit then print a message and return zero.
        else{
            System.out.println("Invalid scale. Try again with scale either C (for celsius) or F (for fahrenheit)"); 
            return 0;
        }
    }

    public float getTempFehr (float degrees, char scale){
        scale = Character.toUpperCase(scale);

        //if the given scale is fahrenheit then just return whatever was passed in parameter
        if(scale == 'F'){
            return degrees;
        }

        // else if the given scale is celsius then use the formula to convert to fahrenheit and return the result
        else if (scale == 'C'){
            return ((9.0f*(degrees/5.0f))+32.0f);
        }

        // if the given scale is anything else than celsius or fahrenheit then print a message and return zero.
        else{
            System.out.println("Invalid scale. Try again with scale either C (for celsius) or F (for fahrenheit)"); 
            return 0;
        }
    }

}