/**
 * Tells the editor to stop editing and accept any partially edited
 * value as the value of the editor.  The editor returns false if
 * editing was not stopped; this is useful for editors that validate
 * and can not accept invalid entries.
 *
 * @return  true if editing was stopped; false otherwise
 */

 jTable1.getCellEditor().stopCellEditing();