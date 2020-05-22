public interface StatusAware {

      enum Status {

           NORMAL,
           GOT_ATTENTION,
           NEEDS_ATTENTION,
           ...

      }
      public Status getStatus(int modelIndex);
} 

public class MyFirstTableModel extends AbstractTableModel implements StatusAware {

       public Statuc getStatus(int modelRow) {
           boolean needsAttention = getObjectAtRow(modelRow).getMsg().getRegNumIn() == 3;
           return needsAttention ? NEEDS_ATTENTION : NORMAL;
       }

       ....
}


public class MySecondTableModel extends AbstractTableModel implements StatusAware {

       public Statuc getStatus(int modelRow) {
           return // the status of the given row
       }

       ....
}

public class MyTable extends JTable { // if you insist on not using JXTable 


      public Component prepareRenderer(...) {
            Component comp = super(...)
            if (getModel() instanceof StatusAware {
                 Status status = ((StatusAware) getModel()).getStatus(convertRowIndexToModel(row));
                 if (NEEDS_ATTENTION == status) {
                       ...
                 } else if (...) {
                      ...
                 } 
            }
            return comp;
       }
}