import com.pi4j.io.*;
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.GpioUtil;

public class Test {

public static void main(String args[]) throws InterruptedException {

// create gpio controller
final GpioController gpio = GpioFactory.getInstance();

Gpio.pinMode (3, Gpio.INPUT) ;          

if (Gpio.digitalRead(3) == 0){ // it is day, so doesn't need LEDs
      System.out.println("Day, LEDs are not switched on");
}else{ // it is night, LEDs are needed
      System.out.println("Night, LEDs are switched on");
}
}