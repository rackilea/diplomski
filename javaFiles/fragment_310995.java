public class EntityTable<T> extends TableView<T>
{
    private final Class<T> entityClass;

    private final List<T> entityList;

    public EntityTable(Class<T> entityClass, List<T> entityList) 
    {
        this.entityClass = entityClass;
        this.entityList = entityList;

        init();
    }

    private void init()
    {
        for (Field field : entityClass.getDeclaredFields())
        {
            if ((field.getType() != Set.class) && (field.getName().compareTo("id") != 0))
            {
                TableColumn column = new TableColumn(field.getName());
                column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));

                getColumns().add(column);
            }
        }

        ObservableList list = FXCollections.observableArrayList(entityList);
        setItems(list);
    }
}