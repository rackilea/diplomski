package main;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Test;

public class TestBidon {
    @Mocked IBidon ibidon;
    @Mocked IBidon ibidon2;
    @Mocked Bidon bidon;
    @Mocked Bidon bidon2;

    @Test public void testBidon() {
        new NonStrictExpectations() {{
            ibidon.doIt();  result = "i: coco";
            ibidon2.doIt(); result = "i: ismael et jordan";
            bidon.doIt();   result = "c: coco";
            bidon2.doIt();  result = "c: ismael et jordan";
        }};

        System.out.println(ibidon.doIt());
        System.out.println(ibidon2.doIt());
        System.out.println(bidon.doIt());
        System.out.println(bidon2.doIt());
    }
}