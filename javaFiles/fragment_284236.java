import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class TableRowContextMenuBuilder<T> {
    private final List<MenuItemConfig<T>> items ;
    private boolean built ;

    public TableRowContextMenuBuilder() {
        this.items = new ArrayList<>();
    }


    public static <T> TableRowContextMenuBuilder<T> create(Class<T> type) {
        return new TableRowContextMenuBuilder<>();
    }

    public TableRowContextMenuBuilder<T> addItem(String text, Consumer<T> handler) {
        if (built) {
            throw new IllegalStateException("Row factory is already built: cannot add new items");
        }
        items.add(new MenuItemConfig<T>(text, handler));
        return this ;
    }

    public TableRowContextMenuBuilder<T> addItem(String text, Runnable handler) {
        return addItem(text, t -> handler.run());
    }

    public Callback<TableView<T>, TableRow<T>> build() {
        if (built) {
            throw new IllegalStateException("Cannot build row factory more than once");
        }
        built = true ;
        return t -> {
            TableRow<T> row = new TableRow<>();
            ContextMenu menu = new ContextMenu();
            row.setContextMenu(menu);
            items.stream()
                .map(config -> config.asMenuItem(row))
                .forEach(menu.getItems()::add);
            return row ;
        };
    }

    public void buildForTable(TableView<T> table) {
        table.setRowFactory(build());
    }


    private static class MenuItemConfig<T> {
        private final String text ;
        private final Consumer<T> handler ;
        MenuItemConfig(String text, Consumer<T> handler) {
            this.text = text;
            this.handler = handler;
        }
        MenuItem asMenuItem(TableRow<T> row) {
            MenuItem item = new MenuItem(text);
            item.setOnAction(e -> handler.accept(row.getItem()));
            return item ;
        }
    }
}