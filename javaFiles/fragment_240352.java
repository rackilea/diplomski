import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class TestyMcTestTest {
    private final Mockery context = new Mockery();

    private final EntityManager em = context.mock(EntityManager.class);
    private final Stacker stacker = new Stacker(em);
    private final Car mockCar = context.mock(Car.class);

    @Test
    public void testCar() {
        context.checking(new Expectations() {{
            oneOf(em).persist(mockCar);
            oneOf(mockCar).setEngine(null);
        }});
        this.stacker.testa(mockCar);
        context.assertIsSatisfied();
    }

    public interface Car {
        void setEngine(Engine engine);
    }

    public interface Engine { }

    public class Stacker {
        private final EntityManager em;

        public Stacker(EntityManager em) {
            this.em = em;
        }

        public void testa(Car car) {
           em.persist(car);
           car.setEngine(null);
        }
    }

    private interface EntityManager {
        void persist(Object o);
    }
}