import com.vaadin.data.Item;
import com.vaadin.data.util.GeneratedPropertyContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.data.util.PropertyValueGenerator;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import java.util.Random;

public class GridWithCalculatedColumn extends VerticalLayout {

    public GridWithCalculatedColumn() {
        // indexed container allowing the definition of custom properties
        IndexedContainer container = new IndexedContainer();
        container.addContainerProperty("firstNumber", Integer.class, 0);
        container.addContainerProperty("secondNumber", Integer.class, 0);

        // generated property container allowing the definition of generated properties
        GeneratedPropertyContainer wrappingContainer = new GeneratedPropertyContainer(container);
        wrappingContainer.addGeneratedProperty("sum", new PropertyValueGenerator<Integer>() {
            @Override
            public Integer getValue(Item item, Object itemId, Object propertyId) {
                // sum the other 2 columns
                // NOTE: for the sake of simplicity this does not handle invalid values such as "null"
                return (Integer) item.getItemProperty("firstNumber").getValue() + (Integer) item.getItemProperty("secondNumber").getValue();
            }

            @Override
            public Class<Integer> getType() {
                return Integer.class;
            }
        });

        // add some dummy data
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Item item = wrappingContainer.addItem(i);
            item.getItemProperty("firstNumber").setValue(random.nextInt(10));
            item.getItemProperty("secondNumber").setValue(random.nextInt(10));
        }


        // basic grid setup
        Grid grid = new Grid();
        grid.setContainerDataSource(wrappingContainer);
        grid.setEditorEnabled(true);
        // disable editing of the "calculated value"
        grid.getColumn("sum").setEditable(false);
        addComponent(grid);
    }
}