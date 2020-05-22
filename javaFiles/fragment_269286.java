import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public class Json {
    public static void main(String[] args)
    {
        final Wrapper wrapper = new Wrapper();
        final Paises paises = wrapper.getPaises();
        paises.getPais().add(Pais.of("Costa Rica", "San José"));
        paises.getPais().add(Pais.of("México", "DF"));
        paises.getPais().add(Pais.of("Argentina", "Buenos Aires"));

        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(wrapper));
    }

    @Data
    private static class Wrapper {
        private Paises paises = new Paises();
    }

    @Data
    private static class Paises {
        private List<Pais> pais = new ArrayList<Pais>();
    }

    @Data(staticConstructor = "of")
    private static class Pais {
        private final String nombre;
        private final String capital;
    }
}