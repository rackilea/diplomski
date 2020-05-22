package snakeyaml;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Test {

    public static void main(String[] args) {
        Yaml yaml = new Yaml(new Constructor(Radios.class));
        try {
           Radios  result = (Radios) yaml.load(new FileInputStream("/home/ofe/dev/projets/projets_non_byo/TachesInfoengine/src/snakeyaml/data.yaml"));
            for (RadioStation radioStation : result.getStations()) {
                System.out.println("radioStation = " + radioStation);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}