package me.losadrian.Pirel;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class App {
// Works here
//  static GeoIPService service = new GeoIPService();
//  static GeoIPServiceSoap client = service.getGeoIPServiceSoap();

    public static void main(String[] args) {
        // Works here too
        GeoIPService service = new GeoIPService();
        final GeoIPServiceSoap client = service.getGeoIPServiceSoap();

        final GpioController gpioPIR = GpioFactory.getInstance();
        final GpioPinDigitalInput sensorPir = gpioPIR.provisionDigitalInputPin(RaspiPin.GPIO_07, PinPullResistance.PULL_DOWN);

        final GpioController gpioREL1 = GpioFactory.getInstance();           
        final GpioPinDigitalOutput rel1 = gpioREL1.provisionDigitalOutputPin(RaspiPin.GPIO_08, "REL", PinState.HIGH);         
        final GpioController gpioREL2 = GpioFactory.getInstance();           
        final GpioPinDigitalOutput rel2 = gpioREL2.provisionDigitalOutputPin(RaspiPin.GPIO_09, "REL", PinState.HIGH);         

        rel1.high();
        rel2.high();

        sensorPir.addListener(new GpioPinListenerDigital() {

            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if (event.getState().isHigh()) {
                    System.out.println("Motion!!");
// Not works here
//                  GeoIPService service = new GeoIPService();
//                  GeoIPServiceSoap client = service.getGeoIPServiceSoap();
                    GeoIP geoIp = client.getGeoIP("212.58.246.92");
                    System.out.println(geoIp.getCountryName());
                    rel1.low();
                    rel2.high();
                }
                if (event.getState().isLow()) {
                    System.out.println("Quiet...");
                    rel1.high();
                    rel2.low();
                }
            }
        });

        try {
            for (;;) {
                Thread.sleep(3000);
            }
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }

    }
}