import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author reegan
 */
public class Listobject extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // Insert Some data

        final ComboBox<ListGroupsObj> listGroups = new ComboBox();


        listGroups.setButtonCell(new GroupListCell());
        listGroups.setCellFactory(new Callback<ListView<ListGroupsObj>, ListCell<ListGroupsObj>>() {
            @Override
            public ListCell<ListGroupsObj> call(ListView<ListGroupsObj> p) {
                return new GroupListCell();
            }
        });

        listGroups.setEditable(true);

        ListGroupsObj ob = ListGroupsObj.newInstance().groupId(12).groupName("Group12");
        listGroups.getItems().addAll(ob);
        ListGroupsObj osb = ListGroupsObj.newInstance().groupId(13).groupName("Group13");
        listGroups.getItems().addAll(osb);
        ListGroupsObj oa = ListGroupsObj.newInstance().groupId(14).groupName("Group14");
        listGroups.getItems().addAll(oa);
        ListGroupsObj oz = ListGroupsObj.newInstance().groupId(15).groupName("Group15");
        listGroups.getItems().addAll(oz);


        // second way to add object
        listGroups.getItems().add(new ListGroupsObj(12, "Group 12"));

        listGroups.setValue(ob);

        // Display the selected Group
//        listGroups.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ListGroupsObj>() {
//            @Override
//            public void changed(ObservableValue<? extends ListGroupsObj> arg0, ListGroupsObj arg1, ListGroupsObj arg2) {
//                if (arg2 != null) {
//                    listGroups.setEditable(true);
//                    System.out.println("Selected Group: " + arg2.getGroupId() + " - " + arg2.getGroupName());
//                }
//            }
//        });


        listGroups.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

            @Override
            public void changed(ObservableValue<? extends Object> ov, Object t, Object t1) {
//                 System.out.println("Selected Group:  " + t1.toString());
                 System.out.println("Selected Group : " + t1);
            }
        });

        final StackPane layout = new StackPane();
        layout.getChildren().add(listGroups);
        layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 15;");
        stage.setScene(new Scene(layout));
        stage.show();
    }

    class GroupListCell extends ListCell<ListGroupsObj> {

        @Override
        protected void updateItem(ListGroupsObj item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                setText(item.getGroupId() + " - " + item.getGroupName());
            }
        }
    }
//    private List<ListGroupsObj> lisGroups;

    public static class ListGroupsObj {

        private int groupId;
        private String groupName;

        public static ListGroupsObj newInstance() {
            return new ListGroupsObj();
        }

        public ListGroupsObj() {
        }

        public ListGroupsObj(int groupId, String groupName) {
            this.groupId = groupId;
            this.groupName = groupName;
        }

        public ListGroupsObj groupId(int groupId) {
            this.groupId = groupId;
            return this;
        }

        public ListGroupsObj groupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public int getGroupId() {
            return groupId;
        }

        public String getGroupName() {
            return groupName;
        }

        @Override
        public String toString() {
            return groupId + " - " + groupName;
        }

    }
}