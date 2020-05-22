import java.util.Collection;

import org.burningwave.core.assembler.ComponentSupplier;
import org.burningwave.core.classes.ClassCriteria;
import org.burningwave.core.classes.hunter.CacheableSearchConfig;
import org.burningwave.core.classes.hunter.ClassHunter;
import org.burningwave.core.classes.hunter.ClassHunter.SearchResult;
import org.burningwave.core.classes.hunter.SearchConfig;
import org.burningwave.core.io.PathHelper;

public class Finder {

    public Collection<Class<?>> find() {
        ComponentSupplier componentConatiner = ComponentContainer.getInstance();
        PathHelper pathHelper = componentConatiner.getPathHelper();
        ClassHunter classHunter = componentConatiner.getClassHunter();

        CacheableSearchConfig searchConfig = SearchConfig.forPaths(
            pathHelper.getMainClassPaths()
        ).by(
            ClassCriteria.create().byClasses((uploadedClasses, currentScannedClass) ->
                uploadedClasses.get(YourParentClass.class).isAssignableFrom(currentScannedClass)
            ).useClasses(
                YourParentClass.class
            )
        );

        SearchResult searchResult = classHunter.findBy(searchConfig);
        return searchResult.getClasses();
    }

}