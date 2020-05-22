@Component
public class GetSelectedFilesCountService extends Service<Integer> {

    @Autowired
    private FileBrowserController fileBrowserController;

    private Integer leafCount;

    @Override
    protected Task<Integer> createTask() {

        return new Task<Integer>() {

            @Override
            protected Integer call() {
                leafCount = 0;
                getSelectedItemsLeafCount(fileBrowserController.getFileBrowser().getSelectionModel().getSelectedItems());
                return leafCount;
            }

            /*****************************************************************
             *Recursively counts the leaves within a single or group of Files 
             *****************************************************************/
            private void getSelectedItemsLeafCount(List<TreeItem<File>> files) {

                for(TreeItem<File> f : files) {
                    if(f.isLeaf()) {
                        leafCount++;
                    }else {
                        getSelectedItemsLeafCount(f.getChildren());
                    }
                }
            }
        };
    }   
}