package default;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 21/08/2016.
 */
public class TestArrays {

    private static final Logger LOG = LogManager.getLogger(TestArrays.class);

    private static class AppConst{
        public static final String KEY_MZUZU = "key_mzuzu";
        public static final String KEY_LILONGWE = "key_lilongwe";
        public static final String KEY_BLANTYRE = "key_blantyre";
        public static final String KEY_ZOMBA = "key_zomba";
    }

    public List<String> getDistricts() {
        return new ArrayList<String>() {{
            //return the default districts, which is all of them
            add(AppConst.KEY_MZUZU);
            add(AppConst.KEY_LILONGWE);
            add(AppConst.KEY_BLANTYRE);
            add(AppConst.KEY_ZOMBA);
        }};
    }

    @Test
    public void testOne() {
        List<String> list = getDistricts();

        LOG.info(list);

        list.add("blantyre");

        LOG.info(list);

        assert(list.size() == 5);
    }
}