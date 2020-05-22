public class TableTransferHandler extends TransferHandler {
    private Popup tipWindow;
    private int tipCol;
    private int tipRow;

    public boolean canImport(TransferHandler.TransferSupport support) {
        ....
        updateDropDeniedTooltip(support, deniedReason)
    }

    private void hideDropDeniedTooltip() {
        if (tipWindow != null) {
            tipWindow.hide();
            tipWindow = null;
        }
    }

    private void updateDropDeniedTooltip(TransferHandler.TransferSupport support, String deniedReason) {
        if (deniedReason != null) {
            JTable.DropLocation dropLocation = (JTable.DropLocation)support.getDropLocation();
            JTable jtable = (JTable)support.getComponent();
            if (tipWindow != null) {
                if (tipRow != dropLocation.getRow() || tipCol != dropLocation.getColumn()) {
                    hideDropDeniedTooltip();
                }
            }
            if (tipWindow == null) {
                tipRow = dropLocation.getRow();
                tipCol = dropLocation.getColumn();
                JToolTip tip = jtable.createToolTip();
                tip.setTipText(result.getReason());
                PopupFactory popupFactory = PopupFactory.getSharedInstance();
                Rectangle cellRect = jtable.getCellRect(tipRow, tipCol, true);
                Point location = jtable.getLocationOnScreen();
                location.x += cellRect.x;
                location.y += cellRect.y;
                tipWindow = popupFactory.getPopup(jtable, tip, location.x, location.y);
                tipWindow.show();
            }
        }
        else {
            hideDropDeniedTooltip();
        }
    }
 }