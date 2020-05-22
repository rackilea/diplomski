@SpringComponent
@Route("dashboard")
public class CallcenterConfigurationView extends VerticalLayout {
    // My approximation of the relevant parts of CallCenterModel
    public static class CallCenterModel {
        private String description;

        public CallCenterModel(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    // A fake "database" containing 100 instances 
    private static List<CallCenterModel> callCenterModels = IntStream.range(0, 100)
            .mapToObj(index -> new CallCenterModel("Call center " + index))
            .collect(Collectors.toList());

    private Grid<CallCenterModel> grid = new Grid<>();

    public CallcenterConfigurationView() {
        grid.addColumn(CallCenterModel::getDescription).setHeader("Description");

        add(grid);

        setSizeFull();
    }

    @PostConstruct
    public void initDataProvider() {
        CallbackDataProvider<CallCenterModel, Void> dataProvider = DataProvider.fromCallbacks(
            query -> callCenterModels
                     .subList(query.getOffset(), query.getOffset() + query.getLimit())
                     .stream(),
            query -> callCenterModels.size());
        grid.setDataProvider(dataProvider);
    }
}