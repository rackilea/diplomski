import org.apache.jmeter.control.ThroughputController;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.SearchByClass;

import java.lang.reflect.Field;
import java.util.Collection;

StandardJMeterEngine engine = ctx.getEngine();
Field test = engine.getClass().getDeclaredField("test");
test.setAccessible(true);
HashTree testPlanTree = (HashTree) test.get(engine);

SearchByClass throughputControllersSearch = new SearchByClass(ThroughputController.class);
testPlanTree.traverse(throughputControllersSearch);
Collection throughputControllers = throughputControllersSearch.getSearchResults();
log.info("Found " + throughputControllers.size() + " throughput controllers in the test plan");