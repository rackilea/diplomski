import java.util.ArrayList;
import java.util.List;

import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ADU_SortOrder<M extends TableModel> extends TableRowSorter<M> {
    public ADU_SortOrder(M model) {
        setModel(model);
    }

    boolean firstTime = true; //Needed in case there are any initial sort keys
    int columnHolder = -1;

    @Override
    public void toggleSortOrder(int column) {
        List<? extends SortKey> sortKeys = getSortKeys();
        if(sortKeys.size() == 0) { //For if there are no initial sort keys
            List<SortKey> keys = new ArrayList<SortKey>();
            keys.add(new SortKey(column, SortOrder.ASCENDING));
            setSortKeys(keys);
            return;
        }

        if (sortKeys.size() > 0 && columnHolder == column || firstTime) {
            if(firstTime) {
                firstTime = false;
                columnHolder = column;
                if(column != sortKeys.get(0).getColumn()) {
                    List<SortKey> keys = new ArrayList<SortKey>(getSortKeys());
                    keys.set(0, new SortKey(column, SortOrder.ASCENDING));
                    setSortKeys(keys);
                    return;
                }
            }

            List<SortKey> keys = new ArrayList<SortKey>(getSortKeys());
            keys.set(0, new SortKey(column, setNextOrder(sortKeys.get(0).getSortOrder())));
            setSortKeys(keys);
            return;
        } else if(sortKeys.size() > 0 && columnHolder != column && !firstTime) {
            List<SortKey> keys = new ArrayList<SortKey>(getSortKeys());
            keys.set(0, new SortKey(column, SortOrder.ASCENDING));
            setSortKeys(keys);
            columnHolder = column;
            return;
        }
        super.toggleSortOrder(column);
    }

    private SortOrder setNextOrder(SortOrder order) {
        switch (order) {
            case ASCENDING:
                return SortOrder.DESCENDING;
            case DESCENDING:
                return SortOrder.UNSORTED;
            case UNSORTED:
                return SortOrder.ASCENDING;
            default:
                return SortOrder.UNSORTED;
        }
    }
}